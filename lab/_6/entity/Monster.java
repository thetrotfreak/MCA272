package entity;

import java.util.HashSet;
import java.util.Random;
import world.Magic;

public class Monster
{
  protected String name;
  protected int hitPoints;
  protected int strength;
  // protected Magic magic;
  public HashSet<Magic> spells;

  public Monster ()
  {
    // this.magic = new Magic ("Earth");
    this.name = "An Unknown Monster";
    this.hitPoints = 1000;
    this.strength = 1000;
    this.spells = new HashSet<Magic> ();
  }

  public Monster (String name, int hitPoints, int strength)
  {
    // this.magic = new Magic ("Earth");
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.spells = new HashSet<Magic> ();
  }

  public String
  getName ()
  {
    return name;
  }

  public int
  getHitPoints ()
  {
    return hitPoints;
  }

  public int
  getStrength ()
  {
    return strength;
  }

  @Override
  public String
  toString ()
  {
    // return "Monster{name=\'" + this.name + "\', hitPoints=" + this.hitPoints
    //     + ", strength=" + this.strength + ", " + this.magic + "}";
    return "Monster{name=\'" + this.name + "\', hitPoints=" + this.hitPoints
        + ", strength=" + this.strength + ", ";
  }

  public void
  learnSpell (Magic spell)
  {
    if (this.spells.add (spell))
      {
        System.out.println ("Monster " + this.name + " learnt a new spell\n"
                            + spell);
      }
  }

  public void
  incantateSpell ()
  {
    Magic[] spells = this.spells.toArray (new Magic[0]);
    int randomIndex = new Random ().nextInt (this.spells.size ());
    Magic spell = spells[randomIndex];
    System.out.println ("**Warging**\t" + this.name + " is chanting a spell "
                        + spell);
  }
}
