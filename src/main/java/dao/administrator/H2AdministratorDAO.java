package dao.administrator;

import model.Administrator;

import javax.sql.RowSet;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;


public class H2AdministratorDAO implements AdministratorDAO {
    private Connection connection = null;

    // initialization
    public H2AdministratorDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public long insertAdministrator(Administrator administrator) {

        String SqlSeqID="select seq_id.nextval from dual;";
        String SqlInsert1="insert into USER(id,name,role,address,login,password,inn," +
                "birth_day,blacklist,insert_date) values ";

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
        String SqlInsert2="("+id;

        long addressId= 0;
        try {
            addressId=administrator.getAddress().getId();
        } catch (Exception e) {
            addressId=0;
        }


        SqlInsert2=SqlInsert2+","+administrator.getName()+","+addressId
                +","+administrator.getLogin()+","+administrator.getPassword()+","+administrator.getInn();
        String dt;
        try {
            dt="TO_DATE("+administrator.getBirthDay().toString()+",'yyyy-MM-dd HH:mm:ss')";
        } catch (Exception e) {
            dt=null;
        }


        SqlInsert2=SqlInsert2+","+dt+","+"0";
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dt = sdfDate.format(administrator.getInsertDate());
        dt="parsedatetime("+dt+",'yyyy-MM-dd HH:mm:ss')";
        SqlInsert2=SqlInsert2+","+dt+");";
        SqlInsert1=SqlInsert1+SqlInsert2;

        int rows = 0;
        try {
            rows = st.executeUpdate(SqlInsert1);
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
