package dao.factory;

import dao.ConnectionException;
import dBase.ConnectorDb;
import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.client.ClientDAO;
import dao.order.OrderDAO;
import dao.product.ProductDAO;

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

        // method to create connections
    public static synchronized Connection createConnection() throws SQLException {
        // Recommend connection pool implementation/usage

        Connection connection=ConnectorDb.getConnection();
        return connection;
    }

    @Override
    public AdministratorDAO getAdministratorDAO() throws ConnectionException {
        try {
            Connection con = createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClientDAO getClientDAO() throws ConnectionException {
        try {
            Connection con = createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() throws ConnectionException {
        try {
            Connection con = createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductDAO getProductDAO()throws ConnectionException {
        try {
            Connection con = createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AddressDAO getAddressDAO()throws ConnectionException {
        try {
            Connection con = createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
