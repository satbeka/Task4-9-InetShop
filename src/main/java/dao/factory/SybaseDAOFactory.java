package dao.factory;

import dBase.ConnectionPool;
import dao.ConnectionException;
import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.client.ClientDAO;
import dao.order.OrderDAO;
import dao.product.ProductDAO;


public class SybaseDAOFactory extends DAOFactory {
    @Override
    public AdministratorDAO getAdministratorDAO(ConnectionPool connectionPool) throws ConnectionException {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO(ConnectionPool connectionPool) throws ConnectionException {
        return null;
    }

    @Override
    public ProductDAO getProductDAO(ConnectionPool connectionPool) throws ConnectionException {
        return null;
    }

    @Override
    public AddressDAO getAddressDAO(ConnectionPool connectionPool) throws ConnectionException {
        return null;
    }
}
