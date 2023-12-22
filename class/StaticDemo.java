class StaticDemon
{
    static int pid=10;
    static int page=25;

    static void
    foo (String str)
    {
      System.out.println ("Hallo from static method" + str);
      page = page + 1;
    }

    static {
      /*
       * do some computation (if needed)
       * to initialize your static stuff
       *
       * a static block is executed only once
       * when the class is first loaded
       * */
      System.out.println ("Hallo from static block");
      page = page + 1;
    }

    public static void
    main (String args[])
    {
        foo ("foo");
    }
}
