package dao.product;

import model.Product;

import javax.sql.RowSet;
import java.sql.Connection;
import java.util.List;


public class H2ProductDAO implements ProductDAO{

    private Connection connection = null;
    // initialization
    public H2ProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertProduct(Product product) {
        return 0;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public Product findProductById(long id) {
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public RowSet selectProductRS(Product product) {
        return null;
    }

    @Override
    public List<Product> selectProductTO() {
        return null;
    }
}
