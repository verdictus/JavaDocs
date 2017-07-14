package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by madalin.mocanu on 7/14/2017.
 */
public class Functie {

    //imi iau un string la inceput si appenduiesc la el "select"
    //returneaza o lista de employee , ia ca parametru un string .
    //parcurg lista de columninfo
    //iterez prin lista de columninfo si appenduiesc la string info.getDbColumnName()
    //appenduiesc restul stringului.
    //fac statement si execut statementul cu parametrul stringul dat inainte.




    public List<Employee> Functie(String departmentName) throws SQLException, ClassNotFoundException {

        Connection c = DBManager.getConnection();

        StringBuilder comanda = new StringBuilder("SELECT ");

        //String numeTabela = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> Coloane = EntityUtils.getColumns((Employee.class));
        for (ColumnInfo info : Coloane )
        {
            comanda = comanda.append(info.getDbColumnName());
            comanda = comanda.append(",");
        }

        comanda.setLength( comanda.length() - 1 );
        comanda.append("FROM EMPLOYEES");
        comanda.append("NATURAL JOIN DEPARTMENTS WHERE lower(department_name) LIKE ");
        comanda.append("%a%");
        comanda.append(departmentName);
        comanda.toString().toLowerCase();

        /*
        QueryBuilder bb = new QueryBuilder();
        bb.addQueryColumns(Coloane);
        bb.setQueryType(QueryType.SELECT);
        */
        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery(comanda.toString());
            List <Employee> lista = new ArrayList<>();
            while (rezultat.next()) {
                Employee t =  Employee.class.newInstance();
                for (ColumnInfo info : Coloane) {
                    Field ff = t.getClass().getDeclaredField(info.getColumnName());
                    ff.setAccessible(true);
                    ff.set(t, EntityUtils.castFromSqlType(rezultat.getObject(info.getDbColumnName()),Employee.class));
                }
                lista.add(t);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }
        return null;
    }
    }

