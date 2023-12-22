abstract class Bank
{
  abstract int getRateOfInterest ();
}

class SBI
{
  int
  getRateOfInterest ()
  {
    return 7;
  }
}

class ICICI extends Bank
{
  int
  getRateOfInterest ()
  {
    return 8;
  }
}

class AbstractBank
{
  public static void
  main (String[] args)
  {
    SBI a = new SBI ();
    Bank b = new ICICI ();

    System.out.println ("SBI RoI = " + a.getRateOfInterest () + "%");
    System.out.println ("ICICI RoI = " + b.getRateOfInterest () + "%");
  }
}
