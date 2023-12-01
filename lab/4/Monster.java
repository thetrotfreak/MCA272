public class Monster
{
  protected String name;
  protected int hitPoints;
  protected int strength;
  protected Magic magic;

  public Monster ()
  {
    this.magic = new Magic ("Earth");
    this.hitPoints = 1000;
    this.strength = 1000;
  }

  public Monster (String name, int hitPoints, int strength)
  {
    this.magic = new Magic ("Earth");
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
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
    return "Monster{name=\'" + this.name + "\', hitPoints=" + this.hitPoints
        + ", strength=" + this.strength + ", " + this.magic + "}";
  }
}
