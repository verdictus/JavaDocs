package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by madalin.mocanu on 7/14/2017.
 */
public class DepartmentDao {

    public List<Department> findAllx1(EntityManager x) throws SQLException, ClassNotFoundException {

        List<Department> xx = x.findAll(Department.class);
        return xx;
    }

    public Department update(EntityManager x)
    {
        Department kk = update(x);
        return kk;
    }

    public Object delete(EntityManager x)
    {
        Object k = delete(x);
        return k;
    }

    public Department insert(EntityManager x)
    {
        Department y = insert(x);
        return y;
    }




}
