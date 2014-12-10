package model;


public interface ClientJob {

    public Order createOrder();
    public boolean confimOrder(Order order);
    public boolean payOrder(Order order);
    public boolean deleteOrder(Order order);
    public void printOrder(Order order);


}
