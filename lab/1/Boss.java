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

  public String castSpell () { return this.name + " is casting a spell"; }

  public String
  castSpell (String spellName)
  {
    return this.name + " is casting the " + spellName + " spell";
  }
}
