package entity;

import interfaces.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import world.Magic;

public class Player
    implements ISaveable, IInventory, IHealable, IBagpack, Runnable
{
  private String name;
  private String weapon;
  private int hitPoints;
  private int strength;
  private final static boolean MORTAL = true;
  private StringBuffer playerHistory;
  private PlayerStats playerStats;
  private ArrayList<String> inventory;

  public Player ()
  {
    this.hitPoints = 100;
    this.strength = 100;
    this.playerHistory = new StringBuffer ();
    this.playerStats = new PlayerStats ();
    this.inventory = new ArrayList<String> ();
  }

  public Player (String name, int hitPoints, int strength)
  {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = "Bare hands";
    this.playerHistory = new StringBuffer ();
    this.playerStats = new PlayerStats ();
    this.inventory = new ArrayList<String> ();
  }

  public Player (String name, int hitPoints, int strength, String weapon)
  {

    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = weapon;
    this.playerHistory = new StringBuffer ();
    this.playerStats = new PlayerStats ();
    this.inventory = new ArrayList<String> ();
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

  public synchronized void
  dealDamage (int damage)
  {
    this.hitPoints -= damage;
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

  /*
   * TODO
   * lab/5
   * feature/multithreading
   */
  @Override
  public void
  run ()
  {
    /*
     * TODO
     * fix design issues
     * don't wanna call Thread.start()
     * which inturn calls addItem(String)
     * passing String item to Thread.start()
     * is a bad design
     * a user can't tell why it needs and where will it use
     */
    this.addItem ("");
    this.heal (1);
    this.emptyBag ();
  }

  public void
  addItem (String item)
  {
    try
      {
        /*
         * TODO
         * Read:
         * https://stackoverflow.com/questions/13613538/making-thread-sleep-for-random-amount-of-ms
         */
        Thread.sleep ((long)Math.random () * 1000);
        if (this.inventory.add (item))
          {
            System.out.println ("An item was added to bag by "
                                + Thread.currentThread ().getName ());
          }
      }
    catch (InterruptedException e)
      {
        System.out.println (e);
      }
  }

  public void
  removeItem (String item)
  {
    this.inventory.remove (item);
  }

  public ArrayList<String>
  getInventory ()
  {
    return this.inventory;
  }

  public void
  heal (int amount)
  {
    int newHitPoints = this.hitPoints + amount;
    if (amount <= 0 || newHitPoints >= 100)
      {
        return;
      }
    this.hitPoints = newHitPoints;
  }

  public boolean
  canHeal ()
  {
    return true;
  }

  public int
  getBagCapacity ()
  {
    return 100;
  }

  public void
  emptyBag ()
  {
    this.inventory = new ArrayList<String> ();
    System.out.println ("Bag emptied!");
    return;
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
