package dao.factory;

import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.client.ClientDAO;
import dao.order.OrderDAO;
import dao.product.ProductDAO;

public abstract class DAOFactory {

    // List of DAO types supported by the dao
    public static final int H2 = 1;
    public static final int ORACLE = 2;
    public static final int SYBASE = 3;


    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract AdministratorDAO getAdministratorDAO();
    public abstract ClientDAO getClientDAO();
    public abstract OrderDAO getOrderDAO();
    public abstract ProductDAO getProductDAO();
    public abstract AddressDAO getAddressDAO();



    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case H2:
                return new H2DAOFactory();
            case ORACLE    :
                return new OracleDAOFactory();
            case SYBASE    :
                return new SybaseDAOFactory();

            default           :
                return null;
        }
    }
}
