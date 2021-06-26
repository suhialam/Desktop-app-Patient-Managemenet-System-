package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQueryUtil {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void connect(boolean autoCommit) {
    
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pms", "root", "");
            System.out.println("Connection Established");
            connection.setAutoCommit(autoCommit);
            statement = connection.createStatement();
            System.out.println("Statment Created");

        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int executeUpdate(String query) throws SQLException {
        int rowsAffected;
        rowsAffected = statement.executeUpdate(query);
        return rowsAffected;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public void commit() {
        try {
            if (!(connection == null || connection.isClosed())) {
                connection.commit();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (!(connection == null || connection.isClosed())) {
                connection.rollback();
                connection.close();
                System.out.println("disconnected sucessfully");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    }

