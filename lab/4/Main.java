public class Main
{
  public static void
  main (String args[])
  {
    Player sanraku = new Player ();
    sanraku.addItem ("Ruby dagger");
    sanraku.addItem ("Tiger hide");
    sanraku.addItem ("gemstone");
    System.out.println (sanraku.write ());
    System.out.println (sanraku.getInventory ());
    sanraku.removeItem ("gemstone");
    System.out.println (sanraku.getInventory ());
    sanraku.killPlayer ();
    System.out.println (sanraku);
    sanraku.heal (10);
    System.out.println (sanraku);
    sanraku.emptyBag ();
    System.out.println (sanraku.getInventory ());

    Boss vampire = new Boss ();
    vampire.heal (1_000);
    System.out.println (vampire);
  }
}
