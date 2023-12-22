package game;

import entity.Monster;
import entity.Player;
import world.Magic;

public class Main
{
  public static void
  main (String args[])
  {
    Player sanraku = new Player ("Sanraku", 100, 100, "Fist");
    System.out.println (sanraku);
    sanraku.addItem ("Dagger");
    sanraku.addItem ("Spell Book");
    sanraku.addItem ("Spell Book");
    sanraku.addItem ("Magic Orb");
    sanraku.addItem ("Magic Orb");
    sanraku.addItem ("Magic Orb");
    System.out.println (sanraku.getInventory ());
    sanraku.removeItem ("Magic Orb");
    System.out.println (sanraku.getInventory ());
    sanraku.emptyBag ();
    System.out.println (sanraku.getInventory ());

    Monster slime = new Monster ("Slime", 10, 10);
    Monster goblin = new Monster ("Goblin", 100, 100);
    slime.learnSpell (new Magic (
        "Water",
        "Water Hydra: Launches a mirage of Water Hyrdas that can easily overwhelm your enemies!"));

    goblin.learnSpell (new Magic (
        "Black",
        "Shadow Bolt: Unleashes a dark projectile that pierces through enemies, draining their life force."));
    goblin.learnSpell (new Magic (
        "Earth",
        "Mystic Ooze: Summons a magical ooze that envelops the target, slowing their movements and reactions."));
    goblin.learnSpell (new Magic (
        "Fire",
        "Searing Emberburst: Ignites the air with fiery embers, creating an explosive burst that engulfs nearby foes."));
    for (int i = 1; i <= 3; i++)
      {
        goblin.incantateSpell ();
      }
  }
}
