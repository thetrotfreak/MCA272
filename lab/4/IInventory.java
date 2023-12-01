import java.util.ArrayList;

interface IInventory
{
  /*
   * TODO
   * Migrate from ArrayList or List to HashMap<String, Integer>
   * */
  void addItem (String item);
  void removeItem (String item);
  ArrayList<String> getInventory ();
}
