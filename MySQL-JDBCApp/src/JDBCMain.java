
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCMain {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            /*Parametres de connexion a la Base de donnees*/
            String url="jdbc:mysql://localhost:3306/db_tuto";
            String user="root";
            String pwd="lenovo";
            Connection conn =DriverManager.getConnection(url, user,pwd);
            
            /*Requetes SQL en JDBC*/
            Statement stat=conn.createStatement();
            int rep=stat.executeUpdate("INSERT INTO person VALUES(1,'NDOMA','Riddy')");
            stat.close();
            conn.close();
        } catch (Exception e) {
        }
    }
}
