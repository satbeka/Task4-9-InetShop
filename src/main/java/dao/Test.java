package dao;


import dBase.ConnectionPool;
import dao.administrator.AdministratorDAO;
import dao.factory.DAOFactory;
import model.Administrator;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;


public class Test {

    public static void main(String[] args) {


        ConnectionPool inst=ConnectionPool.getInstance();

        DAOFactory h2Factory =
                DAOFactory.getDAOFactory(DAOFactory.H2);

        // Create a DAO
        AdministratorDAO administratorDAO = null;

        try {
            administratorDAO = h2Factory.getAdministratorDAO(inst);
        } catch (ConnectionException e) {
            e.printStackTrace();
        }

        // create a new admin
        Administrator administrator=new Administrator();
        administrator.setName("admin");
        administrator.setLogin("admin");
        administrator.setPassword("admin");
        administrator.setInn("1111111111");
        java.util.Date sysDate=new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(sysDate.getTime());
        administrator.setInsertDate(sqlDate);

        long newAdministratorId = administratorDAO.insertAdministrator(administrator);
        administrator.setId(newAdministratorId);

        // Find a customer object. Get the Transfer Object.
        Administrator administrator22 = administratorDAO.findFirstAdministratorByName("admin");

        // modify the values in the Transfer Object.

        String string = "01.01.1980";
        java.util.Date birthDay=null;
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            birthDay=format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //birthDay=birthDay
            //Date birthDay= (Date) format.parse("01.01.1980");

        System.out.println(birthDay.toString());
        Date sqlBirthDay=new Date(birthDay.getTime());
        administrator22.setBirthDay(sqlBirthDay);


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
