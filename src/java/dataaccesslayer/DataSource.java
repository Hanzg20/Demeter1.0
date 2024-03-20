package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

    public static DataSource instance = null;
    private Connection connection = null;
    private String url = "jdbc:mysql://MYSQL8003.site4now.net:3306/db_a88623_fwrp?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String username = "a88623_fwrp";
    private String password = "FWRP1234";

    private DataSource() {
    }

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private Connection createConnection() throws SQLException {
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

//    public void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException ex) {
//                // Log or throw custom exception
//                ex.printStackTrace();
//            }
//        }
//    }
    public int executeUpdate(String sql) throws SQLException {
        try (Connection conn = getInstance().createConnection(); Statement statement = conn.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (SQLException ex) {
            // Log or throw custom exception
            throw ex;
        }
    }

    public int executeUpdate(String sql, Object... params) throws SQLException {
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

    public PreparedStatement query(String sql) throws SQLException {
        try {
            Connection conn = DataSource.getInstance().createConnection();
            return conn.prepareStatement(sql);
        } catch (SQLException ex) {
            // Log or throw custom exception
            throw ex;
        }
    }

    public PreparedStatement query(String sql, Object... params) throws SQLException {
        try {
            Connection conn = getInstance().createConnection();
            // Call createConnection on an instance
            PreparedStatement statement = conn.prepareStatement(sql);

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            return statement;
        } catch (SQLException ex) {
            // Log or throw custom exception
            throw ex;
        }
    }
}
