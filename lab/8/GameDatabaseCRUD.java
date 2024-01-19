import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDatabaseCRUD
{
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/game_db";

  public static void
  main (String[] args)
  {
    try
      {
        // Step 1: Establish a connection
        try (Connection connection
             = DriverManager.getConnection (JDBC_URL, args[0], args[1]))
          {

            // Step 2: CRUD Operations
            // Create
            createPlayer (connection, "Alice", 100, 20, "Sword");
            createPlayer (connection, "Bob", 80, 30, "Staff");
            createPlayer (connection, "Charlie", 100, 22, "Dagger");
            createPlayer (connection, "David", 90, 28, "Bow");
            createPlayer (connection, "Eva", 150, 20, "Holy Sword");
            createPlayer (connection, "Frank", 80, 35, "Magic Wand");
            createPlayer (connection, "Grace", 130, 28, "Battle Axe");
            createPlayer (connection, "Hank", 95, 22, "Short Sword");
            createPlayer (connection, "Ivy", 110, 18, "Mace");
            createPlayer (connection, "Jack", 75, 40, "Dark Staff");
            createMonster (connection, "Dragon", 200, 40);

            // Read
            readPlayers (connection);
            readMonsters (connection);

            // Update
            updatePlayer (connection, 1, "Alice Updated", 120, 25,
                          "Magic Staff");

            // Read after update
            readPlayers (connection);

            // Delete
            deleteMonster (connection, 1);

            // Read after delete
            readMonsters (connection);
          }
        catch (ArrayIndexOutOfBoundsException e)
          {
            System.out.println (
                "USAGE: java GameDatabaseCRUD <username> <password>");
          }
      }
    catch (SQLException e)
      {
        e.printStackTrace ();
      }
  }

  // Create operations
  private static void
  createPlayer (Connection connection, String name, int hitPoints,
                int strength, String weapon) throws SQLException
  {
    String sql
        = "INSERT INTO Player (name, hitPoints, strength, weapon) VALUES (?, ?, ?, ?)";
    try (PreparedStatement preparedStatement
         = connection.prepareStatement (sql))
      {
        preparedStatement.setString (1, name);
        preparedStatement.setInt (2, hitPoints);
        preparedStatement.setInt (3, strength);
        preparedStatement.setString (4, weapon);
        preparedStatement.executeUpdate ();
      }
  }

  private static void
  createMonster (Connection connection, String name, int hitPoints,
                 int strength) throws SQLException
  {
    String sql
        = "INSERT INTO Monster (name, hitPoints, strength) VALUES (?, ?, ?)";
    try (PreparedStatement preparedStatement
         = connection.prepareStatement (sql))
      {
        preparedStatement.setString (1, name);
        preparedStatement.setInt (2, hitPoints);
        preparedStatement.setInt (3, strength);
        preparedStatement.executeUpdate ();
      }
  }

  // Read operations
  private static void
  readPlayers (Connection connection) throws SQLException
  {
    String sql = "SELECT * FROM Player";
    try (Statement statement = connection.createStatement ();
         ResultSet resultSet = statement.executeQuery (sql))
      {
        while (resultSet.next ())
          {
            System.out.println ("Player: "
                                + "ID=" + resultSet.getInt ("id")
                                + ", Name=" + resultSet.getString ("name")
                                + ", HP=" + resultSet.getInt ("hitPoints")
                                + ", Strength=" + resultSet.getInt ("strength")
                                + ", Weapon="
                                + resultSet.getString ("weapon"));
          }
      }
  }

  private static void
  readMonsters (Connection connection) throws SQLException
  {
    String sql = "SELECT * FROM Monster";
    try (Statement statement = connection.createStatement ();
         ResultSet resultSet = statement.executeQuery (sql))
      {
        while (resultSet.next ())
          {
            System.out.println ("Monster: "
                                + "ID=" + resultSet.getInt ("id")
                                + ", Name=" + resultSet.getString ("name")
                                + ", HP=" + resultSet.getInt ("hitPoints")
                                + ", Strength="
                                + resultSet.getInt ("strength"));
          }
      }
  }

  // Update operation
  private static void
  updatePlayer (Connection connection, int playerId, String name,
                int hitPoints, int strength, String weapon) throws SQLException
  {
    String sql
        = "UPDATE Player SET name=?, hitPoints=?, strength=?, weapon=? WHERE id=?";
    try (PreparedStatement preparedStatement
         = connection.prepareStatement (sql))
      {
        preparedStatement.setString (1, name);
        preparedStatement.setInt (2, hitPoints);
        preparedStatement.setInt (3, strength);
        preparedStatement.setString (4, weapon);
        preparedStatement.setInt (5, playerId);
        preparedStatement.executeUpdate ();
      }
  }

  // Delete operation
  private static void
  deleteMonster (Connection connection, int monsterId) throws SQLException
  {
    String sql = "DELETE FROM Monster WHERE id=?";
    try (PreparedStatement preparedStatement
         = connection.prepareStatement (sql))
      {
        preparedStatement.setInt (1, monsterId);
        preparedStatement.executeUpdate ();
      }
  }
}
