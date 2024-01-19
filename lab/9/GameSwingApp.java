import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Player
{
  private String name;
  private int hitPoints;
  private int strength;
  private String weapon;

  Player (String name, int hitPoints, int strength, String weapon)
  {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = weapon;
  }

  @Override
  public String
  toString ()
  {
    return "Player{name='" + name + "', hitPoints=" + hitPoints
        + ", strength=" + strength + ", weapon='" + weapon + "'}";
  }

  public Object[]
  toTableRow ()
  {
    return new Object[] { name, hitPoints, strength };
  }
}

class Monster
{
  private String name;
  private int hitPoints;
  private int strength;

  Monster (String name, int hitPoints, int strength)
  {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
  }

  @Override
  public String
  toString ()
  {
    return "Monster{name='" + name + "', hitPoints=" + hitPoints
        + ", strength=" + strength + "}";
  }

  public Object[]
  toTableRow ()
  {
    return new Object[] { name, hitPoints, strength };
  }
}

class PlayerListFrame extends JFrame
{
  private JTable entityTable;
  private DefaultTableModel entityTableModel;

  public PlayerListFrame ()
  {
    setTitle ("Game Entities");
    setSize (500, 300);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

    entityTableModel = new DefaultTableModel ();
    entityTable = new JTable (entityTableModel);

    // Add columns to the table
    entityTableModel.addColumn ("Name");
    entityTableModel.addColumn ("Hit Points");
    entityTableModel.addColumn ("Strength");
    entityTableModel.addColumn ("Weapon");

    JScrollPane scrollPane = new JScrollPane (entityTable);
    add (scrollPane, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel ();
    JButton showPlayersButton = new JButton ("Show Players");
    JButton showMonstersButton = new JButton ("Show Monsters");

    showPlayersButton.addActionListener (new ActionListener () {
      @Override public void actionPerformed (ActionEvent e) { showPlayers (); }
    });

    showMonstersButton.addActionListener (new ActionListener () {
      @Override public void actionPerformed (ActionEvent e)
      {
        showMonsters ();
      }
    });

    buttonPanel.add (showPlayersButton);
    buttonPanel.add (showMonstersButton);

    add (buttonPanel, BorderLayout.SOUTH);
  }

  private void
  showPlayers ()
  {
    clearTable ();
    List<Player> players = createSamplePlayers ();
    for (Player player : players)
      {
        entityTableModel.addRow (player.toTableRow ());
      }
  }

  private void
  showMonsters ()
  {
    clearTable ();
    List<Monster> monsters = createSampleMonsters ();
    for (Monster monster : monsters)
      {
        entityTableModel.addRow (monster.toTableRow ());
      }
  }

  private List<Player>
  createSamplePlayers ()
  {
    List<Player> players = new ArrayList<> ();
    players.add (new Player ("Alice", 120, 25, "Sword"));
    players.add (new Player ("Bob", 80, 30, "Staff"));
    players.add (new Player ("Charlie", 100, 22, "Dagger"));
    return players;
  }

  private List<Monster>
  createSampleMonsters ()
  {
    List<Monster> monsters = new ArrayList<> ();
    monsters.add (new Monster ("Goblin", 50, 15));
    monsters.add (new Monster ("Orc", 80, 25));
    monsters.add (new Monster ("Troll", 120, 30));
    return monsters;
  }

  private void
  clearTable ()
  {
    entityTableModel.setRowCount (0);
  }
}

public class GameSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlayerListFrame playerListFrame = new PlayerListFrame();
            playerListFrame.setVisible(true);
        });
    }
}
