import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class One
{
  public static void
  main (String args[])
  {
    LocalTime now = LocalTime.now ();
    System.out.println (now.truncatedTo (ChronoUnit.SECONDS));
  }
}
