class Two
{
  public static void
  main (String args[])
  {
    String sentence = "Betty bought some butter";
    args = sentence.split (" ");
    for (String arg : args)
      {
        System.out.println (arg);
      }
  }
}
