import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDatabaseSetup
{
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/game_db";

  public static void
  main (String[] args)
  {
    try
      {
        // Step 1: Establish a connection to MySQL server
        try (Connection connection
             = DriverManager.getConnection (JDBC_URL, args[0], args[1]))
          {
            // Step 2: Create the game_db database
            createDatabase (connection, "game_db");

            // Step 3: Switch to the game_db
            connection.setCatalog ("game_db");

            // Step 4: Create the Player table
            createPlayerTable (connection);

            // Step 5: Create the Monster table
            createMonsterTable (connection);
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

  // Create the game_db database
  private static void
  createDatabase (Connection connection, String dbName) throws SQLException
  {
    String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
    try (Statement statement = connection.createStatement ())
      {
        statement.executeUpdate (sql);
      }
  }

  // Create the Player table
  private static void
  createPlayerTable (Connection connection) throws SQLException
  {
    String sql = "CREATE TABLE IF NOT EXISTS Player ("
                 + "id INT AUTO_INCREMENT PRIMARY KEY,"
                 + "name VARCHAR(255) NOT NULL,"
                 + "hitPoints INT NOT NULL,"
                 + "strength INT NOT NULL,"
                 + "weapon VARCHAR(255) NOT NULL)";
    try (Statement statement = connection.createStatement ())
      {
        statement.executeUpdate (sql);
      }
  }

  // Create the Monster table
  private static void
  createMonsterTable (Connection connection) throws SQLException
  {
    String sql = "CREATE TABLE IF NOT EXISTS Monster ("
                 + "id INT AUTO_INCREMENT PRIMARY KEY,"
                 + "name VARCHAR(255) NOT NULL,"
                 + "hitPoints INT NOT NULL,"
                 + "strength INT NOT NULL)";
    try (Statement statement = connection.createStatement ())
      {
        statement.executeUpdate (sql);
      }
  }
}
