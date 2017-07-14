package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by madalin.mocanu on 7/13/2017.
 */
public class EntityManagerImplTest {


    @Test
    public void FindAllTest() throws SQLException, ClassNotFoundException {
        EntityManagerImpl x1 = new EntityManagerImpl();
        assertEquals(31 , x1.findAll(Department.class).size());
    }

    @Test
    public void insertTest() throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        EntityManagerImpl x1 = new EntityManagerImpl();
        Department dep = new Department();
        //Location y = new Location();
        dep.setDepartmentName("AAA");
        dep.setLocation(1002L);
        x1.insert(dep);
        assertEquals(31 ,  x1.findAll(Department.class).size());
    }
    @Test
    public void getNextIdValueTest() throws SQLException, ClassNotFoundException {
        EntityManagerImpl x1 = new EntityManagerImpl();
        Long nextIdVal = x1.getNextIdVal("Departments", "DEPARTMENT_ID");
        assertEquals(275, (long)nextIdVal);
    }
    @Test
    public void findByIdTest() throws SQLException, ClassNotFoundException {
        EntityManagerImpl x1 = new EntityManagerImpl();
        Department d ;
        d = x1.findById(Department.class,(long)30);
        assertEquals(null, d.getDepartmentName());

    }
    @Test
    public void updateTest() throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        EntityManagerImpl x1  = new EntityManagerImpl();
        Department dep = new Department();
        dep.setId(20L);
        dep.setDepartmentName("Marketing");
        dep.setLocation(1800L);
        dep = x1.update(dep);
        //assertEquals(dep.getDepartmentName() , "Marketing");
    }
    @Test
    public void deleteTest() throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        EntityManagerImpl x1 = new EntityManagerImpl();
        Department dep = new Department();
        dep.setDepartmentName("Marketing");
        dep.setId(20L);
        dep.setLocation(1800L);
        x1.delete(dep);
        assertEquals(x1.findAll(Department.class).size(),31);

    }
    @Test
    public void findByParamsTest() throws SQLException, ClassNotFoundException {
        EntityManagerImpl x1 = new EntityManagerImpl();


    }


}
