package dao.administrator;

import model.Administrator;

import javax.sql.RowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.List;


public class H2AdministratorDAO implements AdministratorDAO {
    private Connection connection = null;

    // initialization
    public H2AdministratorDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public int insertAdministrator(Administrator administrator) {

        String SqlInsert1="insert into table USER(id,name,role,address,login,password,inn," +
                "birh_day,blacklist,insert_date) values ";
        String SqlInsert2="("+    +")";

        Connection cn=this.connection;
        try {
            cn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement st = cn.createStatement();
        int rows = st.executeUpdate("INSERT INTO Employees " +
                "(FirstName, LastName) VALUES " + "(‘Игорь’, ‘Цветков’)");
// Устанавливаем именнованную точку сохранения.
        Savepoint svpt = cn.setSavepoint("NewEmp");

// ...
        rows = st.executeUpdate("UPDATE Employees
                set Address = ‘ул. Седых, 19-34' " +
        "WHERE LastName = 'Цветков'");

// ...
        cn.rollback(svpt);
// ...
// Запись о работнике вставлена, но адрес не обновлен.
        conn.commit();




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
