package exercise4;

import java.util.*;
import java.util.Iterator;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 * <p>
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;
    public int size = 0;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>(16);
        for (int i = 0; i < BUCKET_ARRAY_SIZE; i++) {
            this.buckets.add(new LinkedList<MyEntry>());
        }
    }

    public int hash(String key) {
        if (key == null)
            return 0;
        return Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;
    }

    public String get(String key) {
        //
        int hash = hash(key);
        LinkedList<MyEntry> list = buckets.get(hash);
        for (MyEntry p : list) {
            if (p.key.equals(key))
                return p.value;
        }
        return null;
    }

    public void put(String key, String value) {
        int hash = hash(key);
        LinkedList<MyEntry> list = buckets.get(hash);
        //String previous = null;
        boolean exista = false;
        for (MyEntry p : list) {
            if (p.key.equals(key)) {
                //previous = p.value;
                p.value = value;
                 exista = true;
                break;
            }
        }
        if (!exista)
        {
            size++;
        }
        list.add(new MyEntry(key, value));



    }

    public Set<String> keySet() {
        //
        Set<String> rezultat = new HashSet<String>();
        for (LinkedList<MyEntry> l : buckets)
            for (MyEntry e : l) {
                rezultat.add(e.getKey());
            }
        return rezultat;
    }

    public Collection<String> values() {
        List<String> rezultat = new LinkedList<String>();
        for (LinkedList<MyEntry> l : buckets)
            for (MyEntry e : l) {
                rezultat.add(e.getValue());
            }
        return rezultat;
    }

    public String remove(String key) {
        //  Returns the value associated with the key removed from the map or null if the key wasn't found

        int hash = hash(key);
        List<MyEntry> list = buckets.get(hash);
        for (MyEntry p : list) {
            if (p.key.equals(key)) {
                list.remove(p);
                size--;
                String value = p.value;
                p.key = null;
                p.value = null;
                return value;
            }
        }
        return null;
    }

    public boolean containsKey(String key) {
        int hash = hash(key);
        List<MyEntry> list = buckets.get(hash);
        for (MyEntry p : list) {
            if (p.key.equals(key)) {
                return true;
            }
        }
        return false;

    }

    public boolean containsValue(String value) {

        Iterator<MyEntry> i = entrySet().iterator();
        while (i.hasNext()) {
            MyEntry k = i.next();
            if (k.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        //  Return the number of the Entry objects stored in all the buckets
        return size;
    }

    public void clear() {
        //  Remove all the Entry objects from the bucket list
        for (LinkedList<MyEntry> l : buckets) {
            l.clear();
        }
        size = 0;
    }

    public Set<MyEntry> entrySet() {
        Set<MyEntry> rezultat = new HashSet<MyEntry>();
        for (LinkedList<MyEntry> l : buckets)
            for (MyEntry e : l) {
                rezultat.add(e);
            }
        return rezultat;
    }

    public boolean isEmpty() {
        if (buckets == null)
            return false;
        return true;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
