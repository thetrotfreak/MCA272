public class Player
{
  private String name;
  private String weapon;
  private int hitPoints;
  private int strength;

  public Player ()
  {
    this.hitPoints = 100;
    this.strength = 100;
  }

  public Player (String name, int hitPoints, int strength)
  {
    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = "Bare hands";
  }

  public Player (String name, int hitPoints, int strength, String weapon) {

    this.name = name;
    this.hitPoints = hitPoints;
    this.strength = strength;
    this.weapon = weapon;
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
        + ", strength=" + this.strength + ", weapon=\'" + this.weapon + "\'}";
  }
}
