package q3;

import java.util.UUID;

public class Advertisement
{
  int Advertisement_id;
  String Client_Name;
  String start_date;

  public Advertisement (String Client_Name, String start_date)
  {
    this.Client_Name = Client_Name;
    this.start_date = start_date;
    this.Advertisement_id = UUID.randomUUID ().hashCode ();
  }

  @Override
  public String
  toString ()
  {
    return "Advertisement " + this.Advertisement_id + ":\n"
        + "Client: " + this.Client_Name + "\n"
        + "Date: " + this.start_date;
  }
}
