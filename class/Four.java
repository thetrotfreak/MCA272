class Four
{
  class Client1
  {
    static void
    doCalc (byte... a)
    {
      System.out.println ("byte...");
    }

    static void
    doCalc (long a, long b)
    {
      System.out.println ("byte...");
    }

    static void
    doCalc (Byte s1, Byte s2)
    {
      System.out.println ("Byte, Byte");
    }
  }
  public static void
  main (String args[])
  {
    byte b = 5;
    Client1.doCalc (b, b);
    /*
     * the above method will invoke
     * `doCalc (byte... a)`
     *
     * this is a variable arity method
     * a method that takes unspecified number of arguments
     * and in this case, of type `byte`
     *
     * since, the arguments passed to
     * `doCalc()` is of type `byte`
     * this method be invoked instead of the other ones
     * */
  }
}
