package dao.order;


import model.Order;

import javax.sql.RowSet;
import java.util.List;

public interface OrderDAO {
    public int insertOrder(Order order);
    public boolean deleteOrder(Order order);
    public Order findOrderByName(String name);
    public Order findOrderById(long id);
    public boolean updateOrder(Order order);
    public RowSet selectOrderRS(Order order);
    public List<Order> selectOrderTO();
}
