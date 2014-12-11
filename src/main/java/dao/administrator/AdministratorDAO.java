package dao.administrator;


import model.Administrator;

import javax.sql.RowSet;
import java.util.Collection;

public interface AdministratorDAO {

    public int insertAdministrator(...);
    public boolean deleteAdministrator(...);
    public Administrator findAdministrator(...);
    public boolean updateAdministrator(...);
    public RowSet selectAdministratorRS(...);
    public Collection selectAdministratorTO(...);

}
