package model;


public interface AdministratorJob {

    public boolean markClientBlackList(Client client);
    public boolean unmarkClientBlackList(Client client);
    public boolean removeProduct(Product oldProduct);
    public boolean addProduct(Product newProduct);
    public void printCatalog();


}
