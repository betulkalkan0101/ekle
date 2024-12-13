package login_register_design;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;  // Burada java.sql.Connection sınıfını kullanıyoruz
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author betulkalkan
 */
public class My_CNX {

    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "users_db";
    private static Integer portnumber = 3306;
    private static String password = "root";

    public static Connection getConnection() {
        Connection cnx = null;

        // MysqlDataSource, MySQL veritabanı için bir JDBC DataSource'dur.
        MysqlDataSource datasource = new MysqlDataSource();

        // Veritabanı bağlantı bilgilerini ayarlıyoruz
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);

        try {
            // Burada bağlantıyı alırken zaten Connection türünde bir nesne alıyoruz.
            cnx = datasource.getConnection();  // Burada dönüşüm yapmaya gerek yok
        } catch (SQLException ex) {
            Logger.getLogger(My_CNX.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnx;
    }
}
