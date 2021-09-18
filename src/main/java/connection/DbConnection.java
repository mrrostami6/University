package connection;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This Method Return A Mysql Connection
 */
public class DbConnection {
    public static Connection createConnection() throws SQLException {
        // create a mysql datasource
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        // set Connection Information
        mysqlDataSource.setURL("jdbc:mysql://...../univercity");
        mysqlDataSource.setUser(".....");
        mysqlDataSource.setPassword(".....");
        return mysqlDataSource.getConnection();

    }
}
