package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by madalin.mocanu on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {

    public <T> T findById(Class<T> entityClass, Long id) throws SQLException, ClassNotFoundException {
        Connection c = null;
        c = DBManager.getConnection();
        String numeTabela = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> Coloane = new LinkedList<ColumnInfo>();
        Coloane = EntityUtils.getColumns(entityClass);

        List<Field> Fielduri = new LinkedList<Field>();
        Fielduri = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);
        Condition cond = new Condition();
        for (ColumnInfo xy : Coloane) {
            if (xy.isId() == true) {
                cond.setColumnName(xy.getDbColumnName());
                cond.setValue(id);
            }

        }
        QueryBuilder bb = new QueryBuilder();
        bb.setTableName(numeTabela);
        bb.addCondition(cond);
        bb.addQueryColumns(Coloane);
        bb.setQueryType(QueryType.SELECT);

        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery( bb.createQuery());
            while (rezultat.next()) {
                T t = entityClass.newInstance();
                for (ColumnInfo info : Coloane) {

                    Field ff = t.getClass().getDeclaredField(info.getColumnName());

                    t.getClass().getDeclaredField(info.getColumnName());

                    ff.setAccessible(true);

                    //ff.set(t, info.getColumnName());
                }
                return t;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException {

        Connection c = null;
        c = DBManager.getConnection();
        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery("SELECT MAX" + "(" + columnIdName + ")" + " FROM " + (tableName));
            if (rezultat.next()) {
                return (rezultat.getLong(1) + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> Object insert(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Connection c = null;
        c = DBManager.getConnection();
        String numeTabela = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> Coloane = new LinkedList<ColumnInfo>();
        Coloane = EntityUtils.getColumns(entity.getClass());
        Long id = 0L;
        for (ColumnInfo xy : Coloane) {
            if (xy.isId() == true) {
                xy.setValue(getNextIdVal(numeTabela, xy.getDbColumnName()));
                id = getNextIdVal(numeTabela, xy.getDbColumnName());
            } else {
                Field f = entity.getClass().getDeclaredField(xy.getColumnName());
                f.setAccessible(true);
                xy.setValue(f.get(entity));
            }
        }
        QueryBuilder bb = new QueryBuilder();
        bb.setTableName(numeTabela);
        bb.addQueryColumns(Coloane);
        bb.setQueryType(QueryType.INSERT);

        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery(bb.createQuery());
            return findById(entity.getClass(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) throws SQLException, ClassNotFoundException {

        Connection c = null;
        c = DBManager.getConnection();
        String numeTabela = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> Coloane = new LinkedList<ColumnInfo>();
        Coloane = EntityUtils.getColumns(entityClass);

        QueryBuilder bb = new QueryBuilder();
        bb.setTableName(numeTabela);
        bb.addQueryColumns(Coloane);
        bb.setQueryType(QueryType.SELECT);

        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery(bb.createQuery());
            List<T> lista = new ArrayList<T>();
            while (rezultat.next()) {
                T t = entityClass.newInstance();
                for (ColumnInfo info : Coloane) {
                    Field ff = t.getClass().getDeclaredField(info.getColumnName());
                    ff.setAccessible(true);
                    //ff.set(t, info.getColumnName());
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



