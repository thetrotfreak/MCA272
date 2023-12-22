package interfaces;

import java.util.ArrayList;

public interface IInventory
{
  /*
   * TODO
   * Migrate from ArrayList or List to HashMap<String, Integer>
   * */
  public void addItem (String item);
  public void removeItem (String item);
  public ArrayList<String> getInventory ();
}
