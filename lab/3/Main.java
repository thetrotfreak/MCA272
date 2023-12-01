public class Main
{
  public static void
  main (String[] args)
  {
    // Creating a Magic instance
    Magic magic = new Magic ("Water");
    System.out.println (magic);

    // Using the MagicDetails nested class
    Magic.MagicDetails magicDetails = magic.new MagicDetails (
        "Player can cast magic spells based on the water element!\nUse fire magic to counterattack!");
    System.out.println (magicDetails);

    // Creating a Player
    Player PlayerOne = new Player ("Alice", 150, 120, "Sword");
    System.out.println (PlayerOne);

    // Adding events to Player's history
    PlayerOne.killPlayer ();
    PlayerOne.addToPlayerHistory ("Player joined the game.");
    PlayerOne.addToPlayerHistory ("Player defeated a monster.");
    System.out.println (PlayerOne.getPlayerHistory ());

    // Accessing and updating PlayerStats
    Player.PlayerStats playerStats = PlayerOne.getPlayerStats ();
    playerStats.updatePlayerStats ();
    System.out.println (playerStats);
  }
}
