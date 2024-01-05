package game;

import entity.Player;
import interfaces.IHealable;

public class Main
{
  public static void
  main (String args[])
  {
    IHealable healingAction = (player, amount) ->
    {
      int newHitPoints = player.getHitPoints () + amount;
      if (amount <= 0 || newHitPoints >= 100)
        {
          return;
        }
      player.setHitPoints (player.getHitPoints () + amount);
    };

    Player sanraku = new Player ("Sanraku", 10, 100, "Fist");
    System.out.println (sanraku);
    sanraku.heal (healingAction, 10);
    System.out.println (sanraku);
  }
}
