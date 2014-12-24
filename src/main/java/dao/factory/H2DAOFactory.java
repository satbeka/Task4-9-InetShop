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
    //private static ConnectionPool pool = null;
    //private static Connection connection;

    /*
        // method to create connections
    public static Connection createConnection() throws SQLException {
        // Recommend connection pool implementation/usage
        Connection connection=ConnectorDb.getConnection();
        return connection;
    }
    */

    public static Connection createConnection(ConnectionPool connectionPool) {
        return connectionPool.takeConnection();
    }

    @Override
    public AdministratorDAO getAdministratorDAO(ConnectionPool connectionPool) throws ConnectionException {

        Connection con = createConnection(connectionPool);
        return new H2AdministratorDAO(con);
        //return null;
    }

    public ClientDAO getClientDAO(ConnectionPool connectionPool) throws ConnectionException {
        Connection con = createConnection(connectionPool);
        return new H2ClientDAO(con);
    }

    @Override
    public OrderDAO getOrderDAO(ConnectionPool connectionPool) throws ConnectionException {
        Connection con = createConnection(connectionPool);
        return new H2OrderDAO(con);
    }

    @Override
    public ProductDAO getProductDAO(ConnectionPool connectionPool)throws ConnectionException {
        Connection con = createConnection(connectionPool);
        return new H2ProductDAO(con);
    }

    @Override
    public AddressDAO getAddressDAO(ConnectionPool connectionPool)throws ConnectionException {
        Connection con = createConnection(connectionPool);
        return null;
    }

}
