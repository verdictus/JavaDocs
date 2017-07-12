package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by madalin.mocanu on 7/12/2017.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod()
    {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!" , "Departments" , tableName);
    }
    @Test
    public void testGetTableNameMethod2()
    {
        String tableName2 = EntityUtils.getTableName(Employee.class);
        assertEquals("Table name should be Employee" , "Employee" , tableName2);
    }
    @Test
    public void testGetColumnsMethod()
    {
        List<ColumnInfo> rezultat =  new LinkedList<ColumnInfo>();

        rezultat = EntityUtils.getColumns(Department.class);
        int rezultat2 = rezultat.size();
        assertEquals("Trebuie sa fie 3" , 3 , rezultat2);

    }
    @Test
    public void testGetColumnsMethod2()
    {
        List<ColumnInfo> rezultat = new LinkedList<ColumnInfo>();
        rezultat = EntityUtils.getColumns(Employee.class);
        int rezultat2 = rezultat.size();
        assertEquals("Rezultatul trebuie sa fie 11 " ,  11 , rezultat2);
    }
    @Test
    public void castFromsqlTypeTest()
    {
        Object rezultat = new Object();

        rezultat =  EntityUtils.castFromsqlType(5.32,Integer.class);

        assertEquals("ssssssssss" , 5.32 , rezultat );

    }
    @Test
    public void getFieldsByAnnotationsTest()
    {
        List<Field> rez = new LinkedList<Field>();
        List<Field> rez2 = new LinkedList<Field>();

        rez =  EntityUtils.getFieldsByAnnotations(Department.class,Table.class);

        assertEquals(" " , rez2 , rez);


    }
    @Test
    public void getSqlValueTest()
    {

    }
}
