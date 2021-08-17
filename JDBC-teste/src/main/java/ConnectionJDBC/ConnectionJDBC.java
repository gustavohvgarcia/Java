package ConnectionJDBC;
import com.mysql.cj.jdbc.BlobFromLocator;

import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public ConnectionJDBC() throws SQLException {
    }

    protected static Connection getConnection(){
            try{
                String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";
                Connection conn = DriverManager.getConnection(urlConnection, "root", "--------");
                System.out.println("Conexao sucesso");
                return conn;
            } catch (Exception e) {
                System.out.println("Conexao falha");
                e.printStackTrace();
                return null;
            }
    }
    }
