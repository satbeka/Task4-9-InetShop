package dao;


import dao.administrator.AdministratorDAO;
import dao.factory.DAOFactory;
import model.Administrator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

    public static void main(String[] args) {


        DAOFactory h2Factory =
                DAOFactory.getDAOFactory(DAOFactory.H2);

        // Create a DAO
        AdministratorDAO administratorDAO =
                null;
        try {
            administratorDAO = h2Factory.getAdministratorDAO();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }

        // create a new admin
        Administrator administrator=new Administrator();
        administrator.setName("admin");
        administrator.setLogin("admin");
        administrator.setPassword("admin");
        administrator.setInn("1111111111");
        Date sysDate = new Date();
        administrator.setInsertDate(sysDate);

        long newAdministratorId = administratorDAO.insertAdministrator(administrator);
        administrator.setId(newAdministratorId);

        // Find a customer object. Get the Transfer Object.
        Administrator administrator22 = administratorDAO.findAdministratorByName("admin");

        // modify the values in the Transfer Object.

        //String string = "01.01.1980";
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            Date birthDay= format.parse("01.01.1980");
            administrator22.setBirthDay((java.sql.Date) birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        administrator22.setLogin("admin22");

        // update the customer object using the DAO
        administratorDAO.updateAdministrator(administrator22);



        /*
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
*/


    }




}
