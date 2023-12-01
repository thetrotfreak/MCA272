class LabTwo
{
  public static void
  main (String[] args)
  {
    String text = """
        "We realize that while our workers were thriving,
        the surrounding villages were still suffering.
        It became our goal to uplift their quality of life as well.
        I remeber seeing a family of 4 on a motorbike who were risking their
        lives for lack of an alternative." The alternative mentioned here
        is the Tata Nano, which soon after came as the world's cheapest car
        on retail at a starting price of only Rs. 1 Lakh. There were the
        words of Ratan Tata in a recent post by Humans of Bombay which formed
        the basis of his decision to come up with car like Tata Nano.
        """;
    System.out.println(text);

    System.out.println (text.charAt (text.length () / 2));
    System.out.println (text.compareTo (text.toUpperCase ()));
    System.out.println (text.concat ("~ On a rainy day in November 2003."));
    System.out.println (text.contains ("Tata Nano"));
    System.out.println (text.endsWith ("."));
    System.out.println (text.equals (text));
    System.out.println (text.equalsIgnoreCase (text.toLowerCase ()));

    System.out.println (String.format (
        "Write a Java Program to implement String methods with the text specified below:\n%s",
        text));
    System.out.println (text.getBytes ());

    char portionOfText[] = new char[text.length ()];
    text.getChars (0, text.length () / 2, portionOfText, 0);
    System.out.println (portionOfText);

    System.out.println (text.indexOf ("Ratan Tata"));
    System.out.println (text.intern ().hashCode () == text.hashCode ());
    System.out.println (text.isEmpty ());
    System.out.println (text.join ("~ A quote"));
    System.out.println (text.lastIndexOf ("Tata"));
    System.out.println (text.replace ('"', '\''));
    System.out.println (
        text.replaceAll ("Tata Nano", "Tata Nano (discontinued, 2017)"));
    for (String quote : text.split ("\""))
      {
        System.out.println (quote);
      }
    System.out.println (text.startsWith ("We"));
    System.out.println (text.substring (text.length () / 2, text.length ()));
    System.out.println (text.trim ());
    System.out.println (String.valueOf (
        text.replaceAll (" ", "").toCharArray (), 0, text.length () / 4));
  }
}
