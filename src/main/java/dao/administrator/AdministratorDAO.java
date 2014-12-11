package dao.administrator;


import model.Administrator;

import javax.sql.RowSet;
import java.util.List;

public interface AdministratorDAO {

    public int insertAdministrator(Administrator administrator);
    public boolean deleteAdministrator(Administrator administrator);
    public Administrator findAdministratorByName(String name);
    public Administrator findAdministratorById(long id);
    public boolean updateAdministrator(Administrator administrator);
    public RowSet selectAdministratorRS(Administrator administrator);
    public List<Administrator> selectAdministratorTO();

}
