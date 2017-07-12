package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by madalin.mocanu on 7/12/2017.
 */
public class EntityUtils {

    private EntityUtils()
    {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity)
    {
        Table x = (Table)entity.getAnnotation(Table.class);
        String y = x.name();
        return y;
    }

    public static List<ColumnInfo> getColumns(Class entity)
    {
        List<ColumnInfo> list1 = new LinkedList<ColumnInfo>();
        Field[] ListOfFields = entity.getDeclaredFields();
        int i = 0;
        for ( ;i<ListOfFields.length;i++)
        {
            Column c = (Column)ListOfFields[i].getAnnotation(Column.class);
            Id j = (Id)ListOfFields[i].getAnnotation(Id.class);
            ColumnInfo info = new ColumnInfo();
            info.setColumnName(ListOfFields[i].getName());
            info.setColumnType(ListOfFields[i].getType());
            if(c != null) {
                //info.setDbColumnName(j.name());
                info.setId(true);
            }
            else
            {
                //info.setDbColumnName(c.getClass().getName());
                info.setId(false);
            }
            list1.add(info);
        }
        return list1;
    }

    public static Object castFromsqlType(Object value,Class wantedType)
    {
        if ( value instanceof BigDecimal && wantedType == Integer.class)
        {
            return (Integer)value;
        }
        else if ( value instanceof BigDecimal && wantedType == Long.class)
        {
            return (Long)value;
        }
        else if ( value instanceof BigDecimal && wantedType == Float.class)
        {
            return (Float)value;
        }
        else if (value instanceof BigDecimal && wantedType == Double.class)
        {
            return (Double)value;
        }
        else
        {
            return value;
        }
    }
    public static List<Field> getFieldsByAnnotations(Class clazz , Class annotation)
    {
        List<Field> ListOfFields2 =  new ArrayList<Field>();
        List<Field> ListOfFields = new ArrayList<Field>();
        ListOfFields = Arrays.asList(clazz.getDeclaredFields());

        for  (int i = 0 ; i < ListOfFields.size();i++)
        {
            Annotation x = ListOfFields.get(i).getAnnotation(annotation);
            if ( x != null )
            {
                ListOfFields2.add(ListOfFields.get(i));
            }
        }
        return ListOfFields2;

    }

    public static Object getSqlValue(Object object)
    {

        Table x = (Table)object.getClass().getAnnotation(Table.class);
        if ( x != null )
        {
            List<Field> ListOfFields = new ArrayList<Field>();
            ListOfFields = Arrays.asList(object.getClass().getDeclaredFields());
            for ( int i = 0 ; i < ListOfFields.size() ; i++ )
            {
                Id y = (Id)object.getClass().getAnnotation(Id.class);
                        if( y != null)
                        {
                            return object;
                        }
            }
        }
       return object;
    }
}
