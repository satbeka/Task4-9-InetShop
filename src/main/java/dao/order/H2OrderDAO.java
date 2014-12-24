package dao.order;

import model.Order;

import javax.sql.RowSet;
import java.sql.Connection;
import java.util.List;


public class H2OrderDAO implements OrderDAO {
    private Connection connection = null;
    // initialization
    public H2OrderDAO(){}

    @Override
    public int insertOrder(Order order) {
        return 0;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return false;
    }

    @Override
    public Order findOrderByName(String name) {
        return null;
    }

    @Override
    public Order findOrderById(long id) {
        return null;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public RowSet selectOrderRS(Order order) {
        return null;
    }

    @Override
    public List<Order> selectOrderTO() {
        return null;
    }
}
