import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.IO.println;

public class Database
{
    // sto usando MAMP perchè XAMPP per MacOS fa pena - Uso porta 8889, pw e username 'root'

    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:8889/db_spotify";
    private final String user = "root";
    private final String password = "root";

    public Database() throws SQLException {
        if (connect())
        {
            println("Connessione avvenuta");
        }
        else
        {
            println("Connessione rifiutata");
        }
    }

    private boolean connect() throws SQLException {
        connection = DriverManager.getConnection(URL, user, password);
        return true;
    }

    public void showAll() throws SQLException {
        String query = "SELECT * FROM songs";
        ResultSet risultati = connection.createStatement().executeQuery(query);
        while (risultati.next())
        {
            println(risultati.getString(1));
            println(risultati.getString(2));
        }
    }
}
