public class Boss extends Monster
{
  private int magicPoints;

  Boss ()
  {
    super ("Boss", 1_00_000, 1_00_000);
    this.magicPoints = 10_000;
  }

  Boss (int magicPoints)
  {
    super ("Boss", 1_00_000, 1_00_000);
    this.magicPoints = magicPoints;
  }

  public String
  castSpell ()
  {
    return this.name + " is casting a spell";
  }

  public String
  castSpell (String spellName)
  {
    return this.name + " is casting the " + spellName + " spell";
  }

  public void
  heal (int amount)
  {
    int newHitPoints = this.hitPoints + amount;
    if (amount <= 0 || newHitPoints >= 1_00_000)
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
}
