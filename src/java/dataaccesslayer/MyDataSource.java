/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author liyingguo
 */
@WebListener
public class MyDataSource implements ServletContextListener {
    private static DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/your_datasource_name");

            // Store the MyDataSource in ServletContext for later use if needed
            sce.getServletContext().setAttribute("dataSource", dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // No cleanup necessary for context destruction
    }

    public static Connection getConnection() throws SQLException {
        
        return dataSource.getConnection();
    }
    
    public static int execute(String sql) throws SQLException {
        try (
                Connection conn = MyDataSource.getConnection(); 
                Statement statement = getConnection().createStatement()) {
            return statement.executeUpdate(sql);
        } catch (SQLException ex) {
            // Log or throw custom exception
            throw ex;
        }
    }

    public static int execute(String sql, Object... params) throws SQLException {
        try (
                Connection conn = MyDataSource.getConnection(); // Call createConnection on an instance
                 PreparedStatement statement = getConnection().prepareStatement(sql)) {
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

    public static PreparedStatement prepareStatement(Connection connection,String sql) throws SQLException {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException ex) {
            // Log or throw custom exception
            throw ex;
        }
    }

    public static PreparedStatement prepareStatement(Connection connection,String sql, Object... params) throws SQLException {
        try {
            // Call createConnection on an instance
            PreparedStatement statement = connection.prepareStatement(sql);

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