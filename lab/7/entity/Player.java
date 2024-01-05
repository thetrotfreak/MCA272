package entity;

import interfaces.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import world.Magic;

public class Player implements ISaveable, IInventory, IBagpack
{
  private String name;
  private String weapon;
  private int hitPoints;
  private int strength;
  private final static boolean MORTAL = true;
  private StringBuffer playerHistory;
  private PlayerStats playerStats;
  private HashMap<String, Integer> inventory;

  public Player ()
  {
    this.hitPoints = 100;
    this.strength = 100;
    this.playerHistory = new StringBuffer ();
    this.playerStats = new PlayerStats ();
    this.inventory = new HashMap<String, Integer> ();
  }

  public Player (String name, int hitPoints, int strength)
  {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = "Bare hands";
    this.playerHistory = new StringBuffer ();
    this.playerStats = new PlayerStats ();
    this.inventory = new HashMap<String, Integer> ();
  }

  public Player (String name, int hitPoints, int strength, String weapon)
  {

    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = weapon;
    this.playerHistory = new StringBuffer ();
    this.playerStats = new PlayerStats ();
    this.inventory = new HashMap<String, Integer> ();
  }

  public String
  getName ()
  {
    return name;
  }

  public void
  setName (String name)
  {
    this.name = name;
  }

  public String
  getWeapon ()
  {
    return weapon;
  }

  public void
  setWeapon (String weapon)
  {
    this.weapon = weapon;
  }

  public int
  getHitPoints ()
  {
    return hitPoints;
  }

  public void
  setHitPoints (int hitPoints)
  {
    this.hitPoints = hitPoints;
  }

  public int
  getStrength ()
  {
    return strength;
  }

  public void
  setStrength (int strength)
  {
    this.strength = strength;
  }

  @Override
  public String
  toString ()
  {
    return "Player{name=\'" + this.name + "', hitPoints=" + this.hitPoints
        + ", strength=" + this.strength + ", weapon=\'" + this.weapon + "\'"
        + ", Can be killed? " + Player.MORTAL
        + "}\nPlayer History:" + this.getPlayerHistory ();
  }

  public final void
  killPlayer ()
  {
    this.hitPoints = 0;
    addToPlayerHistory ("Player killed on " + LocalDateTime.now ());
  }

  public void
  addToPlayerHistory (String event)
  {
    this.playerHistory.append (event).append ("\n");
  }

  public String
  getPlayerHistory ()
  {
    return playerHistory.toString ();
  }

  public void
  read (List<String> list)
  {
    /*
     * TODO
     * FileIO / Serialization
     * */
    if (list != null && list.size () > 0)
      {
        this.name = list.get (0);
        this.weapon = list.get (1);
        this.hitPoints = Integer.parseInt (list.get (2));
        this.strength = Integer.parseInt (list.get (3));
      }
  }

  public List<String>
  write ()
  {
    /*
     * TODO
     * FileIO
     * */
    ArrayList<String> details = new ArrayList<String> ();
    details.add (this.name);
    details.add (this.weapon);
    details.add (Integer.toString (this.hitPoints));
    details.add (Integer.toString (this.strength));
    return details;
  }

  public void
  addItem (String item)
  {
    // this.inventory.add (item);
    if (!this.inventory.containsKey (item))
      {
        this.inventory.put (item, 1);
      }
    else
      {
        this.inventory.put (item, this.inventory.get (item) + 1);
      }
  }

  public void
  removeItem (String item)
  {
    // this.inventory.remove (item);
    if (this.inventory.containsKey (item))
      {
        Integer itemCount = this.inventory.get (item);
        if (itemCount.equals (1))
          {
            this.inventory.remove (item);
          }
        else
          {
            this.inventory.put (item, itemCount - 1);
          }
      }
  }

  public HashMap<String, Integer>
  getInventory ()
  {
    return this.inventory;
  }

  public void
  heal (IHealable healable, int amount)
  {
    healable.heal (this, amount);
  }

  public void
  emptyBag ()
  {
    this.inventory = new HashMap<String, Integer> ();
    System.out.println ("Bag emptied!");
  }

  public class PlayerDetails
  {
    private int xp;

    PlayerDetails (int xp) { this.xp = xp; }

    @Override
    public String
    toString ()
    {
      return "Player Details: XP = " + this.xp;
    }
  }

  public static class PlayerStats
  {
    private int gamesPlayed;
    private int victories;

    public PlayerStats ()
    {
      this.gamesPlayed = 0;
      this.victories = 0;
    }

    public void
    updatePlayerStats (int... stats)
    {
      if (stats.length == 2)
        {
          this.gamesPlayed = stats[0];
          this.victories = stats[1];
        }
      else if (stats.length == 0)
        {
          this.gamesPlayed++;
          this.victories++;
        }
    }

    @Override
    public String
    toString ()
    {
      return "Player Stats: Games Played = " + this.gamesPlayed
          + ", Total Victories = " + this.victories;
    }
  }

  public PlayerStats
  getPlayerStats ()
  {
    return this.playerStats;
  }
}
