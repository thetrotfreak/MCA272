public class Weapon implements Upgradable<Integer>
{
  public String name;
  public int level;
  public int damage;

  public Weapon (String name)
  {
    this.name = name;
    this.level = 1;
    this.damage = 10;
  }

  private void
  getDamageLevel ()
  {
    this.damage = this.level * 10;
  }

  @Override
  public void
  upgrade (Integer upgrade)
  {
    int new_lvl = upgrade + this.level;

    if (new_lvl > Upgradable.MAX_LVL)
      {
        System.out.println ("Weapon " + this.name + " has been maxed out!");
        this.getDamageLevel ();
      }
    else if (new_lvl > this.level)
      {
        this.level = new_lvl;
        this.getDamageLevel ();
      }
    else
      {
        System.out.println ("Weapon can not be downgraded.");
      }
  }

  @Override
  public String
  toString ()
  {
    return "The weapon " + this.name + " is capable of dealing " + this.damage
        + " damage at level " + this.level;
  }
}
