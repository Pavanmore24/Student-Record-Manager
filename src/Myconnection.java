import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/STM?useSSL=false",
                    "root",
                    "PD03@_MORE"
            );
            System.out.println(" Connection is successful");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(" Failed to connect to DB");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println(" Connection closed");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
