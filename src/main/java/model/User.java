package model;

import java.sql.Date;
import java.util.Enumeration;

/**
 * Created by 1 on 09.12.2014.
 */
public abstract class User {

   long id;
   String name;
    enum Role { ADMINISTRATOR, CLIENT, SOMEONE };
    //ADDRESS
    String login;
    String password;
    String inn;
    Date birthDay;
    //int blacklist;

}
