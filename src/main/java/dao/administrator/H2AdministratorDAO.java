package dao.administrator;

import model.Administrator;

import javax.sql.RowSet;
import java.sql.Connection;
import java.util.List;


public class H2AdministratorDAO implements AdministratorDAO {
    private Connection connection = null;

    // initialization
    public H2AdministratorDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public int insertAdministrator(Administrator administrator) {
        return 0;
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
