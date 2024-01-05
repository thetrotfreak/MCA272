package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface IInventory
{
  public void addItem (String item);
  public void removeItem (String item);
  // public ArrayList<String> getInventory ();
  /* TODO
   * HashMap<> is not MT-safe
   * Explore its MT-safe counterpart
   * ConcurrentHashMap<>
   *
   */
  public HashMap<String, Integer> getInventory();
}
