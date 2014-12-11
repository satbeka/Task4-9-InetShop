package dao.factory;

import dao.address.AddressDAO;
import dao.administrator.AdministratorDAO;
import dao.client.ClientDAO;
import dao.order.OrderDAO;
import dao.product.ProductDAO;

/**
 * Created by 1 on 11.12.2014.
 */
public class OracleDAOFactory extends DAOFactory {
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
