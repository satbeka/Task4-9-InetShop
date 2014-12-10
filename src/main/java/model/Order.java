package model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Order implements Serializable {
    private long id;
    private String number;
    private int quantity;
    private Product product;
    private Client client;
    private BigDecimal sum;
    private BigDecimal sumPaid;
    private Date date;




}
