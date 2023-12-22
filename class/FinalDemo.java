class FinalDemo
{
  final static String foo = "bar";

  public static void
  main (String args[])
  {
    /*
     * this is fine as "it is not a redeclaration of a final member variable"
     * but a local variable
     */
    final String foo = "foo";

    /* uncommenting this line result in an error
     * since final members are essentially constants
     */
    // foo = "foo";

    /*
     * if you are using a local variable
     * bearing the same name as that of a
     * member variable of its enclosing class
     * then to distinguish between them
     * use them like this:
     * var // final local variable
     * ClassName.MEMBER_VARIABLE // final static
     */
    System.out.println (foo);
    System.out.println (FinalDemo.foo);
  }
}
