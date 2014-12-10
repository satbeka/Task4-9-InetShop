package model;



import java.sql.Date;
import java.util.Comparator;

public class Product implements Comparator<Product>{
    private long id;
    private String name;
    private int active;
    private Date insertDate;

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compare(Product o1, Product o2) {
        return o1.insertDate.compareTo(o2.insertDate);
    }
}
