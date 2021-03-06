package dBase;


import dao.ConnectionException;

import java.sql.*;
import java.util.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
//import java.util.concurrent.PriorityBlockingQueue;


public class ConnectionPool implements Connection{

    public static final int POOL_SIZE = 10;
    private BlockingQueue<Connection> connectionQueue;


    private ConnectionPool(){

        /*
//------------
        Locale locale=Locale.ENGLISH;
        Locale current = Locale.getDefault();
        Locale.setDefault(locale);
        ResourceBundle resource = ResourceBundle.getBundle("dbh2");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        String driverName=resource.getString("driver");
        Locale.setDefault(current);
*/
//----------
        connectionQueue
                = new ArrayBlockingQueue<Connection>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {

            Connection connection = null;
            try {
                //connection = DriverManager.getConnection(url, user, pass);//ConnectorDb.getConnection();
                connection = ConnectorDb.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionQueue.offer (connection);

        }

    }

    @Override
    public Statement createStatement() throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return null;
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return null;
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {

    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return false;
    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public void rollback() throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return null;
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {

    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return false;
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {

    }

    @Override
    public String getCatalog() throws SQLException {
        return null;
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {

    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return 0;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return null;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

    }

    @Override
    public void setHoldability(int holdability) throws SQLException {

    }

    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return null;
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return null;
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return null;
    }

    @Override
    public Clob createClob() throws SQLException {
        return null;
    }

    @Override
    public Blob createBlob() throws SQLException {
        return null;
    }

    @Override
    public NClob createNClob() throws SQLException {
        return null;
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return null;
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return false;
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {

    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {

    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return null;
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return null;
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return null;
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return null;
    }

    @Override
    public void setSchema(String schema) throws SQLException {

    }

    @Override
    public String getSchema() throws SQLException {
        return null;
    }

    @Override
    public void abort(Executor executor) throws SQLException {

    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return 0;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    private static class ConnectionPoolHolder{
        private static ConnectionPool instance=new ConnectionPool();
    }

    public static ConnectionPool getInstance(){
        ConnectionPoolHolder connectionPoolHolder=new ConnectionPoolHolder();
        return connectionPoolHolder.instance;
    }

    public Connection takeConnection () {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {/*TODO log*/
            System.out.println("e=" + e.toString());
        }
        return connection;
    }

    private void clearConnectionQueue () throws SQLException {
        Connection connection;
        while ((connection = connectionQueue.poll ()) != null) {
            if (!connection.getAutoCommit ()) {
                connection.commit ();
            }
            connection.close ();
        }
    }

    public void releaseConnection (Connection connection) {
        try {
            if (!connection.isClosed ()) {
                if (!connectionQueue.offer (connection)) {

                }
            }
        } catch (SQLException e) {

        }
    }


    public static void dispose () throws SQLException {
        if (ConnectionPoolHolder.instance != null) {
            ConnectionPoolHolder.instance.clearConnectionQueue();
            ConnectionPoolHolder.instance = null;

        }
    }






    /* pool to 5connection
    * */
}
