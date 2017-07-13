package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by madalin.mocanu on 7/13/2017.
 */
public class DBManager implements DBProperties {
    static boolean ok;

    static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" +DBProperties.PORT + ":xe";

    private DBManager()
    {
        throw new UnsupportedOperationException();
    }

    private static void registerDriver() throws ClassNotFoundException {
        ok = false;
        try {
            Driver myDriver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(myDriver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        registerDriver();
        Connection x  = DriverManager.getConnection(CONNECTION_STRING , DBProperties.USER ,DBProperties.PASS);
        return x;

    }
    public static boolean CheckConnection(Connection connection) throws SQLException {
        boolean rezultat = false ;
        try (Statement x = connection.createStatement()) {
            rezultat = x.execute("SELECT 1 FROM DUAL TASK");
            /*while (rezultat.next())
            {
                System.out.println("Conexiune ");
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            connection.close();
            //rezultat.close();
        }
        return rezultat;


    }
}
