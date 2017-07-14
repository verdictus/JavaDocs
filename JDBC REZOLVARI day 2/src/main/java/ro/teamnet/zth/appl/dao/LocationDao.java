package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by madalin.mocanu on 7/14/2017.
 */
public class LocationDao {


    public List<Location> findAllx1(EntityManager x) throws SQLException, ClassNotFoundException {

        List<Location> xx = x.findAll(Location.class);
        return xx;
    }

    public Location update(EntityManager x)
    {
        Location kk = update(x);
        return kk;
    }

    public Object delete(EntityManager x)
    {
        Object k = delete(x);
        return k;
    }

    public Location insert(EntityManager x)
    {
        Location y = insert(x);
        return y;
    }

}
