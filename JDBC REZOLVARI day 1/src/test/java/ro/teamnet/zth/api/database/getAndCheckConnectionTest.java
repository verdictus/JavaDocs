package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by madalin.mocanu on 7/13/2017.
 */
public class getAndCheckConnectionTest {

    @Test
    public void getAndCheckConnTest() throws SQLException, ClassNotFoundException {
       Connection c = null;
       assertNotNull(DBManager.getConnection());
    }
    @Test
    public void CheckConnTest2() throws SQLException, ClassNotFoundException {

        Connection c = DBManager.getConnection();
        assertEquals( true , DBManager.CheckConnection(c));
    }
}
