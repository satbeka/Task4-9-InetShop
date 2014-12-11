package dao.product;


import model.Product;
import javax.sql.RowSet;
import java.util.List;

public interface ProductDAO {
    public int insertProduct(Product product);
    public boolean deleteProduct(Product product);
    public Product findProductByName(String name);
    public Product findProductById(long id);
    public boolean updateProduct(Product product);
    public RowSet selectProductRS(Product product);
    public List<Product> selectProductTO();
}
