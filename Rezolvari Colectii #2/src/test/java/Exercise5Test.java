
import exercise5.MyHashMapWithMyImplementedList;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Radu.Hoaghe on 7/6/2017.
 */
public class Exercise5Test {

    @Test
    public void testPutMethod() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        HashMap<String, String> expected = getExpected();

        Assert.assertEquals("Test size", myHashMap.size(), expected.size());

        Assert.assertEquals("Test if expected contains all the keys from MyHashMap", true,
                expected.keySet().containsAll(myHashMap.keySet()));

        Assert.assertEquals("Test if expected contains all the values from MyHashMap", true,
                expected.values().containsAll(myHashMap.values()));

        Assert.assertEquals("Test if MyHashMap contains all the keys from expected", true,
                myHashMap.keySet().containsAll(expected.keySet()));

        Assert.assertEquals("Test if MyHashMap contains all the values from expected", true,
                myHashMap.values().containsAll(expected.values()));
    }

    @Test
    public void testPutMethodWithNullKey() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        HashMap<String, String> expected = getExpected();
        myHashMap.put(null, "Accra");
        expected.put(null, "Accra");

        Assert.assertEquals("Test size", myHashMap.size(), expected.size());

        Assert.assertEquals("Test if expected contains all the keys from MyHashMap", true,
                expected.keySet().containsAll(myHashMap.keySet()));

        Assert.assertEquals("Test if expected contains all the values from MyHashMap", true,
                expected.values().containsAll(myHashMap.values()));

        Assert.assertEquals("Test if MyHashMap contains all the keys from expected", true,
                myHashMap.keySet().containsAll(expected.keySet()));

        Assert.assertEquals("Test if MyHashMap contains all the values from expected", true,
                myHashMap.values().containsAll(expected.values()));
    }

    @Test
    public void testPutMethodWithDuplicates() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        HashMap<String, String> expected = getExpected();
        myHashMap.put("ALGERIA","Algiers");
        expected.put("ALGERIA","Algiers");

        Assert.assertEquals("Test size", myHashMap.size(), expected.size());

        Assert.assertEquals("Test if expected contains all the keys from MyHashMap", true,
                expected.keySet().containsAll(myHashMap.keySet()));

        Assert.assertEquals("Test if MyHashMap contains all the keys from expected", true,
                myHashMap.keySet().containsAll(expected.keySet()));
    }

    @Test
    public void testRemoveMethod() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        Assert.assertTrue("Test remove method", myHashMap.remove("ALGERIA") != null);

        Assert.assertEquals("Test size", myHashMap.size(), 3);

        Assert.assertEquals("Test if key was removed", true, myHashMap.get("ALGERIA") == null);
    }

    @Test
    public void testRemoveMethodWithNonexistentObject() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        Assert.assertTrue("Test remove with nonexistent object", myHashMap.remove("KENYA") == null);

        Assert.assertEquals("Test size", myHashMap.size(), 4);
    }

    @Test
    public void testGetMethod() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        HashMap<String, String> expected = getExpected();

        Assert.assertTrue("Test get method",
                myHashMap.get("ALGERIA").equals(expected.get("ALGERIA")));
    }

    @Test
    public void testGetMethodWithNonexistentObject() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();

        Assert.assertTrue("Test get method with nonexistent object",
                myHashMap.get("NIGER") == null);
    }

    @Test
    public void testGetMethodWithNull() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();

        Assert.assertTrue("Test get method with null",
                myHashMap.get(null) == null);
    }

    @Test
    public void testContainsKeyValueMethod() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();

        Assert.assertTrue("Test containsKey method returns true",
                myHashMap.containsKey("ALGERIA"));

        Assert.assertTrue("Test containsValue method returns true",
                myHashMap.containsValue("Algiers"));

        Assert.assertFalse("Test containsKey method returns false",
                myHashMap.containsKey("TOGO"));

        Assert.assertFalse("Test containsValue method returns false",
                myHashMap.containsValue("Lome"));
    }

    @Test
    public void testClearAndIsEmptyMethod() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        myHashMap.clear();

        Assert.assertTrue("Test clear method", myHashMap.size() == 0);
        Assert.assertTrue("Test isEmpty method", myHashMap.isEmpty());
    }

    @Test
    public void testEntrySetMethod() throws Exception {
        MyHashMapWithMyImplementedList myHashMap = getMyHashMap();
        HashMap<String, String> expected = getExpected();

        Assert.assertEquals("Test if expected contains all the entries from MyHashMap", true,
                expected.entrySet().containsAll(myHashMap.entrySet()));

        Assert.assertEquals("Test if MyHashMap contains all the entries from expected", true,
                myHashMap.entrySet().containsAll(expected.entrySet()));
    }

    private MyHashMapWithMyImplementedList getMyHashMap(){
        MyHashMapWithMyImplementedList myHashMap = new MyHashMapWithMyImplementedList();
        myHashMap.put("ALGERIA","Algiers");
        myHashMap.put("BENIN","Porto-Novo");
        myHashMap.put("BURKINA FASO","Ouagadougou");
        myHashMap.put("CHAD","Ndjamena");
        return myHashMap;
    }

    private HashMap<String, String> getExpected() {
        HashMap<String, String> expected = new HashMap<String, String>();
        expected.put("ALGERIA","Algiers");
        expected.put("BENIN","Porto-Novo");
        expected.put("BURKINA FASO","Ouagadougou");
        expected.put("CHAD","Ndjamena");
        return expected;
    }
}
