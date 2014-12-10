import dBase.ConnectorDb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLDataException;

/**
 * 9.	Система Интернет-магазин.
 * Администратор осуществляет ведение каталога Товаров.
 * Клиент делает и оплачивает Заказ на Товары.
 * Администратор может занести неплательщиков в “черный список”.
 */
public class Test {
    public static void main(String[] args) throws Exception{

        Connection connection=ConnectorDb.getConnection();
        DatabaseMetaData databaseMetaData=connection.getMetaData();
        System.out.println("Db="+databaseMetaData.getDatabaseProductName()+" "+
        databaseMetaData.getDriverVersion()
        );





    }
}
