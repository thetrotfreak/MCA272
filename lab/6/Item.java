public class Item implements Collectible<String>
{
  public String name;
  public int count;

  public Item (String name)
  {
    this.name = name;
    this.count = 1;
  }

  @Override
  public String
  collect ()
  {
    this.count++;
    System.out.println ("Collected " + this.count + "x " + this.name);
    return this.name;
  }
}
