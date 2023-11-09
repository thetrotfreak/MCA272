public class Hero extends Player
{

  private int magicPoints;

  Hero ()
  {
    super ("Hero", 1_00_000, 1_00_000, "Magic Sword");
    this.nagicPoints = 1000;
  }

  Hero (int magicPoints) { this.magicPoints = 10_000; }
}
