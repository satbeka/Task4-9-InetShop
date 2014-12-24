package dao.factory;

import dBase.ConnectionPool;
import dao.ConnectionException;
import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.client.ClientDAO;
import dao.order.OrderDAO;
import dao.product.ProductDAO;


public class OracleDAOFactory extends DAOFactory {
    @Override
    public AdministratorDAO getAdministratorDAO() throws ConnectionException {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() throws ConnectionException {
        return null;
    }

    @Override
    public ProductDAO getProductDAO() throws ConnectionException {
        return null;
    }

    @Override
    public AddressDAO getAddressDAO() throws ConnectionException {
        return null;
    }
}
