package dao.factory;

import dBase.ConnectorDb;
import dao.client.ClientDAO;
import dao.order.OrderDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class H2DAOFactory extends DAOFactory {
    //private static ConnectionPool pool = null;
    private static Connection connection;

    public void setConnection(Connection connection){
        H2DAOFactory.connection=connection;
    }
/*
    public void setConnectionPool(ConnectionPool pool){
        MYSQLDAOFactory.pool = pool;
  */

        // method to create Cloudscape connections
    public static Connection createConnection() throws SQLException {
        // Use DRIVER and DBURL to create a connection
        // Recommend connection pool implementation/usage

        Connection connection=ConnectorDb.getConnection();
    }
    public ClientDAO getClientDAO() {
        // CloudscapeCustomerDAO implements CustomerDAO
        return new H2ClientDAO();
    }
    public AccountDAO getAccountDAO() {
        // CloudscapeAccountDAO implements AccountDAO
        return new CloudscapeAccountDAO();
    }
    public OrderDAO getOrderDAO() {
        // CloudscapeOrderDAO implements OrderDAO
        return new CloudscapeOrderDAO();
    }
    ...
}
