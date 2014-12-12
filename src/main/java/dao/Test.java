package dao;


import dao.administrator.AdministratorDAO;
import dao.factory.DAOFactory;
import model.Administrator;

public class Test {

    public static void main(String[] args) throws ConnectionException{


        DAOFactory h2Factory =
                DAOFactory.getDAOFactory(DAOFactory.H2);

        // Create a DAO
        AdministratorDAO administratorDAO =
                h2Factory.getAdministratorDAO();

        // create a new admin
        Administrator administrator=new Administrator();
        administrator.setName("admin");
        administrator.setLogin("admin");
        administrator.setPassword("admin");
        administrator.setInn("1111111111");
        administrator.setInsertDate("");

        int newAdministratorId = administratorDAO.insertAdministrator();

        // Find a customer object. Get the Transfer Object.
        Customer cust = custDAO.findCustomer(...);

// modify the values in the Transfer Object.
        cust.setAddress(...);
        cust.setEmail(...);
// update the customer object using the DAO
        custDAO.updateCustomer(cust);

// delete a customer object
        custDAO.deleteCustomer(...);
        // select all customers in the same city
        Customer criteria=new Customer();
        criteria.setCity("New York");
        Collection customersList =
                custDAO.selectCustomersTO(criteria);
// returns customersList - collection of Customer
// Transfer Objects. iterate through this collection to
// get values.



    }




}
