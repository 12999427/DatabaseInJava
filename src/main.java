import java.sql.SQLException;
import static java.lang.IO.println;

void main()
{
    try
    {
        Database db = new Database();
        db.showAll();
    }
    catch (SQLException sqle)
    {
        println("Errore " + sqle.getMessage());
    }
}