
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnectivity {

    public static void main(String[] args) {
        Connection connection;
        Statement statement;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pms", "root", "");
            System.out.println("Connection Established");
            connection.setAutoCommit(true);
            statement = connection.createStatement();

            String query = "insert into companies (company_name,address,phone_number) values('Ali Pharma','Peshawar','12344');";

            int x = statement.executeUpdate(query);
            System.out.println(x);

        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

}
