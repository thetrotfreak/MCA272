public class Garbage
{
  @Override
  public void
  finalize () throws Throwable
  {
    System.out.println (this + " is getting GCed");
    super.finalize ();
  }
  public static void
  main (String args[])
  {
    Garbage g = new Garbage ();
  }
}
