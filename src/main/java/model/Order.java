package model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Order implements Serializable {
    private Long id;
    private String number;
    private int quantity;
    private Product product;
    private Client client;
    private BigDecimal sum;
    private BigDecimal sumPaid;
    private Date date;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
