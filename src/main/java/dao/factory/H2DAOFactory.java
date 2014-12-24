package dao.factory;

import dBase.ConnectionPool;
import dao.ConnectionException;
import dBase.ConnectorDb;
import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.administrator.H2AdministratorDAO;
import dao.client.ClientDAO;
import dao.client.H2ClientDAO;
import dao.order.H2OrderDAO;
import dao.order.OrderDAO;
import dao.product.H2ProductDAO;
import dao.product.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class H2DAOFactory extends DAOFactory {
    public ConnectionPool getPool() {
        return pool;
    }

    public void setPool(ConnectionPool pool) {
        this.pool = pool;
    }

    private ConnectionPool pool = null;
    //private static Connection connection;

    /*
        // method to create connections
    public static Connection createConnection() throws SQLException {
        // Recommend connection pool implementation/usage
        Connection connection=ConnectorDb.getConnection();
        return connection;
    }
    */


    @Override
    public AdministratorDAO getAdministratorDAO() {

        return new H2AdministratorDAO();
    }

    public ClientDAO getClientDAO() {
        return new H2ClientDAO();
    }

    @Override
    public OrderDAO getOrderDAO(){
        return new H2OrderDAO();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new H2ProductDAO();
    }

    @Override
    public AddressDAO getAddressDAO() {
        return null;
    }

}
