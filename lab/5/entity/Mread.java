public class Mread
{
  public static void
  main (String[] args)
  {
    Thread t1 = new Thread();
    Thread t2 = new Thread();
    Thread t3 = new Thread();
    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MAX_PRIORITY);
    t3.setPriority (Thread.MAX_PRIORITY);
    t1.start();
    t2.start();
    t3.start ();
  }
}

