package dao.factory;

import dBase.ConnectionPool;
import dao.ConnectionException;
import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.client.ClientDAO;
import dao.order.OrderDAO;
import dao.product.ProductDAO;

import java.sql.SQLException;

public abstract class DAOFactory {

    // List of DAO types supported by the dao
    public static final int H2 = 1;
    public static final int ORACLE = 2;
    public static final int SYBASE = 3;


    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    //public abstract AdministratorDAO getAdministratorDAO() throws ConnectionException;

    public abstract AdministratorDAO getAdministratorDAO(ConnectionPool connectionPool) throws ConnectionException;

    //public abstract ClientDAO getClientDAO() throws ConnectionException;

    //public abstract OrderDAO getOrderDAO() throws ConnectionException;

    //public abstract ProductDAO getProductDAO() throws ConnectionException;

    //public abstract AddressDAO getAddressDAO() throws ConnectionException;


    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case H2:
                return new H2DAOFactory();
            case ORACLE:
                return new OracleDAOFactory();
            case SYBASE:
                return new SybaseDAOFactory();

            default:
                return null;
        }
    }

    public abstract OrderDAO getOrderDAO(ConnectionPool connectionPool) throws ConnectionException;

    public abstract ProductDAO getProductDAO(ConnectionPool connectionPool)throws ConnectionException;

    public abstract AddressDAO getAddressDAO(ConnectionPool connectionPool)throws ConnectionException;
}
