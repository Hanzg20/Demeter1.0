package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

    public static DataSource instance = null;
    private static Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/fwrp?useSSL=false&allowPublicKeyRetrieval=true";
    private String username = "root";
    private String password = "";

    DataSource() {
    }

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection createConnection() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            // Log or throw custom exception
            throw ex;
        }
        return connection;
    }

    public Connection getConn() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                // Log or throw custom exception
                ex.printStackTrace();
            }
        }
    }

    public int executeUpdate(String sql) throws SQLException {
        try (Statement statement = getConn().createStatement()) {
            return statement.executeUpdate(sql);
        } catch (SQLException ex) {
            // Log or throw custom exception
            throw ex;
        }
    }
    
public static int executeUpdate(String sql, Object... params) throws SQLException {
    try (Connection conn = getInstance().createConnection(); // Call createConnection on an instance
         PreparedStatement statement = conn.prepareStatement(sql)) {
        // Set parameters
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement.executeUpdate();
    } catch (SQLException ex) {
        // Log or throw custom exception
        throw ex;
    }
}

    public static ResultSet executeQuery(String sql) throws SQLException {
        try (Connection conn = DataSource.getInstance().createConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            return statement.executeQuery();
        } catch (SQLException ex) {
        // Log or throw custom exception
            throw ex;
        }
    }
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        try {
         Connection conn = getInstance().createConnection(); // Call createConnection on an instance
            PreparedStatement statement = conn.prepareStatement(sql);

        // Set parameters
            for (int i = 0; i < params.length; i++) {
             statement.setObject(i + 1, params[i]);
         }
        
         return statement.executeQuery();
        } catch (SQLException ex) {
        // Log or throw custom exception
        throw ex;
        }
    }
}
