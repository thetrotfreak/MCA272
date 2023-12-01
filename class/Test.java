class Test {
  public static void test(String str) {
    int check = 4;
    if (check == str.length()) {
      System.out.print(str.charAt(check -= 1) + ", ");
    } else {
      System.out.print(str.charAt(0) + ", ");
    }
  }

  public static void main(String args[]) {
    // int i = 0, j = 2;
    // do
    // {
    // i = ++i;
    // j--;
    // }
    // while (j > 0);
    // System.out.println (i);

    // String s1 = "abc";
    // String s2 = new String ("abc");
    // if (s1 == s2)
    // System.out.println (1);
    // else
    // System.out.println (2);
    // if (s1.equals (s2))
    // System.out.println (3);
    // else
    // System.out.println (4);

    // test ("four");
    // test ("tee");
    // test ("to");

    // Short s1 = 200;
    // Integer s2 = 400;
    // Long s3 = (long)s1 + s2; // line n1
    // String s4 = (String)(s3 * s2);// line n2
    // System.out.println("Sum is " + s4);

    // StringBuilder sb = new StringBuilder("Java");
    // String s = "Java";
    // if (sb.toString().equals(s.toString())) {
    // System.out.println("Match 1");
    // } else if (sb.equals(s)) {
    // System.out.println("Match 1");
    // } else {
    // System.out.println("No Match");
    // }

    // int i = 0;
    // increment(i);
    // i++;
    // System.out.println(i);

    Integer i = Integer.valueOf(1) + Integer.valueOf(2);
    switch (i) {
      case 3:
        System.out.println("three");
        break;
      default:
        System.out.println("other");
        break;
    }
  }

  static void increment(int index) {
    index++;
  }
}
