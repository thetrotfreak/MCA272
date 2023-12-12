package q3;

public class Free_Add extends Advertisement
{
  int free_add_time_duration;

  public Free_Add (String Client_Name, String start_date,
                   int free_add_time_duration)
  {
    super (Client_Name, start_date);
    this.free_add_time_duration = free_add_time_duration;
  }

  @Override
  public String
  toString ()
  {
    return "Free " + super.toString () + "\n"
        + "Free Duration: " + this.free_add_time_duration;
  }

  public boolean
  ofDuration (int months)
  {
    return this.free_add_time_duration > months;
  }

}
