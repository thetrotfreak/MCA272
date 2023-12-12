package q3;

public class Commercial_Add extends Advertisement
{
  int size_of_add;
  int prize_of_add;

  public Commercial_Add (String Client_Name, String start_date,
                         int size_of_add, int prize_of_add)
  {

    super (Client_Name, start_date);
    this.size_of_add = size_of_add;
    this.prize_of_add = prize_of_add;
  }

  public int
  add_Cost ()
  {
    return this.size_of_add * prize_of_add;
  }

  @Override
  public String
  toString ()
  {
    return "Commerical " + super.toString () + "\nSize: " + this.size_of_add
        + "\n"
        + "Prize: " + this.prize_of_add;
  }
}
