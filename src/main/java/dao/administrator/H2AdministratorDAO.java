package dao.administrator;

import model.Administrator;
import model.User;

import javax.sql.RowSet;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


public class H2AdministratorDAO implements AdministratorDAO {
    private Connection connection = null;

    // initialization
    public H2AdministratorDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public long insertAdministrator(Administrator administrator) {

        String SqlSeqID="select seq_id.nextval from dual;";
        String SqlInsert2="insert into USER(id,name,role,address,login,password,inn," +
                "birth_day,insert_date) values (?,?,?,?,?,?,?,?,?)";

        Connection cn=this.connection;
        try {
            cn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement st = null;
        try {
            st = cn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;
        long id = -1;
        try {
            rs=st.executeQuery(SqlSeqID);
            if ( rs.next() ) {
                id=rs.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement st2=null;
        try {
            st2=cn.prepareStatement(SqlInsert2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            st2.setLong(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            st2.setString(2, administrator.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st2.setInt(3, 1);  //Administrator role=1
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long addressId= 0;
        try {
            addressId=administrator.getAddress().getId();
        } catch (Exception e) {
            addressId=0;
        }
        try {
            st2.setLong(4,addressId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st2.setString(5, administrator.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st2.setString(6, administrator.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st2.setString(7, administrator.getInn());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st2.setDate(8, administrator.getBirthDay());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        java.util.Date sysdate=new java.util.Date();
        try {

            st2.setDate(9, (Date) sysdate);//insert_date
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rs = null;
        try {
            rs = st2.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.next();
            id=rs.getLong("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            cn.commit();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return -1;
    }

    @Override
    public boolean deleteAdministrator(Administrator administrator) {
        return false;
    }

    @Override
    public Administrator findAdministratorByName(String name) {
        return null;
    }

    @Override
    public Administrator findAdministratorById(long id) {
        return null;
    }

    @Override
    public boolean updateAdministrator(Administrator administrator) {
        return false;
    }

    @Override
    public RowSet selectAdministratorRS(Administrator administrator) {
        return null;
    }

    @Override
    public List<Administrator> selectAdministratorTO() {
        return null;
    }
}
