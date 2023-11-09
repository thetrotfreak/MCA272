public class Main
{
  public static void
  main (String[] args)
  {
      Monster orc = new Monster();
      Player player_1 = new Player ();
      Boss boss_1 = new Boss ();
      System.out.println(boss_1.castSpell ());
      System.out.println (boss_1.castSpell ("Stop Time"));
  }
}
