package game;

import entity.*;
import java.util.ArrayList;

public class Main
{
  public static void
  main (String args[])
  {
    Player[] players = new Player[5];

    for (int i = 0; i < 5; i++)
      {
        players[i] = new Player (Integer.toString (i), 100, 100);
        Thread p = new Thread (players[i]);
        p.setPriority (Thread.MAX_PRIORITY);
        p.start ();
        /*
         * TODO
         * make multiple monsters fight a single player
         * multiple monsters can deal damage to the same player
         * but only one's damage will be dealt at a time
         */
        players[i].dealDamage (50);
      }
    for (Player player : players)
      {
        System.out.println (player);
      }
  }
}
