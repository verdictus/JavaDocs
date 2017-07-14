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
import java.util.Map;

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
            ResultSet rezultat = stat.executeQuery(bb.createQuery());
            while (rezultat.next()) {
                T t = entityClass.newInstance();
                for (ColumnInfo info : Coloane) {

                    Field ff = t.getClass().getDeclaredField(info.getColumnName());

                    t.getClass().getDeclaredField(info.getColumnName());

                    ff.setAccessible(true);

                    //ff.set(t, rezultat.getObject(info.getDbColumnName()));
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
                    //ff.set(t, rezultat.getObject(info.getDbColumnName()));
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

    @Override
    public <T> T update(T entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Connection c = DBManager.getConnection();

        String numeTabela = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> Coloane = new LinkedList<ColumnInfo>();
        Coloane = EntityUtils.getColumns(entity.getClass());

        List<Field> Fielduri = new LinkedList<Field>();

        for (ColumnInfo info : Coloane) {
            Field ff = entity.getClass().getDeclaredField(info.getColumnName());
            ff.setAccessible(true);
            info.setValue(ff.get(entity));
        }

        Condition cond = new Condition();


        Fielduri = EntityUtils.getFieldsByAnnotations(entity.getClass(), Id.class);
        Fielduri.get(0).setAccessible(true);
        cond.setColumnName(Coloane.get(0).getDbColumnName());
        cond.setValue(Fielduri.get(0).get(entity));
        Object xyz = Fielduri.get(0).get(entity);


        QueryBuilder bb = new QueryBuilder();
        bb.setTableName(numeTabela);
        bb.addCondition(cond);
        bb.addQueryColumns(Coloane);
        bb.setQueryType(QueryType.UPDATE);

        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery(bb.createQuery());
            return null;
        } catch (SQLException e) {
            System.out.println("do nothing");
        }
        return null;
    }

    @Override
    public void delete(Object entity) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Connection c = DBManager.getConnection();

        String numeTabela = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> Coloane = new LinkedList<ColumnInfo>();
        Coloane = EntityUtils.getColumns(entity.getClass());


        List<Field> Fielduri = new LinkedList<Field>();

        for (ColumnInfo info : Coloane) {
            Field ff = entity.getClass().getDeclaredField(info.getColumnName());
            ff.setAccessible(true);
            info.setValue(ff.get(entity));
        }
        Condition cond = new Condition();

        Fielduri = EntityUtils.getFieldsByAnnotations(entity.getClass(), Id.class);
        Fielduri.get(0).setAccessible(true);
        cond.setColumnName(Coloane.get(0).getDbColumnName());
        cond.setValue(Fielduri.get(0).get(entity));

        QueryBuilder bb = new QueryBuilder();
        bb.setTableName(numeTabela);
        bb.addCondition(cond);
        //bb.addQueryColumns(Coloane);
        bb.setQueryType(QueryType.DELETE);

        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery(bb.createQuery());
        } catch (SQLException e) {
            System.out.println("do nothing");
        }
    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Connection c = DBManager.getConnection();

        String numeTabela = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> Coloane = new LinkedList<ColumnInfo>();
        Coloane = EntityUtils.getColumns(entityClass);
        List<Condition> conditii = new LinkedList<Condition>();

        for (ColumnInfo info : Coloane) {
            Field ff = entityClass.getDeclaredField(info.getColumnName());
            ff.setAccessible(true);
            info.setValue(ff.get(entityClass));
        }

        QueryBuilder bb = new QueryBuilder();
        bb.setTableName(numeTabela);
        bb.addQueryColumns(Coloane);
        bb.setQueryType(QueryType.SELECT);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            //cheia string coloana
            //value e object
            Condition COND = new Condition();
            COND.setColumnName(entry.getKey());
            COND.setValue(entry.getValue());
            bb.addCondition(COND);
        }

        try (Statement stat = c.createStatement()) {
            ResultSet rezultat = stat.executeQuery(bb.createQuery());
            List<T> lista = new ArrayList<T>();
            while (rezultat.next()) {
                T t = entityClass.newInstance();
                for (ColumnInfo info : Coloane) {
                    Field ff = t.getClass().getDeclaredField(info.getColumnName());
                    ff.setAccessible(true);
                    ff.set(t, rezultat.getObject(info.getDbColumnName()));
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



