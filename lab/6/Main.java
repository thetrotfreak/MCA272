public class Main
{
  public static void
  main (String[] args)
  {
    Weapon sword = new Weapon ("The Holy Grail");
    Weapon spear = new Weapon ("Heaven's Thunder Spear");

    spear.upgrade (10);
    sword.upgrade (99);
    sword.upgrade (-99);
    System.out.println (spear);
    System.out.println (sword);

    Item coin = new Item ("Coin");
    coin.collect ();
  }
}
