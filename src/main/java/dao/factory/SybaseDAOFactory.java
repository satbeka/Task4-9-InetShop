package dao.factory;

import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.client.ClientDAO;
import dao.order.OrderDAO;
import dao.product.ProductDAO;


public class SybaseDAOFactory extends DAOFactory {
    @Override
    public AdministratorDAO getAdministratorDAO() {
        return null;
    }

    @Override
    public ClientDAO getClientDAO() {
        return null;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }

    @Override
    public ProductDAO getProductDAO() {
        return null;
    }

    @Override
    public AddressDAO getAddressDAO() {
        return null;
    }
}
