package dao;


import java.sql.SQLException;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
        super();
    }
    public ConnectionException(String msg) {
        super(msg);
    }


}
