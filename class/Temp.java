public class Temp<T>
{
  public <T> void
  add (T t1, T t2)
  {
    System.out.println (t1.toString () + t2.toString ());
  }

  public static void
  main (String args[])
  {
    Temp<String> s = new Temp<> ();
    Temp<Integer> i = new Temp<> ();
    i.add (1, 2);
    s.add ("Bivas", "Kumar");
  }
}
