package team.mediasoft.study.java.ee.hashmap;

import java.util.*;

public class CustomHashMap<K, V> {

    private CustomHashTable table = new CustomHashTable();

    CustomHashMap() {}

    public Object get(K key) {
        return table.find(key).getValue();
    }

    public void put(K key, V value) {
        Set<K> allKeys = keySet();
        if (key == null) {
            System.out.print("Cannot put null key");
        } else if (allKeys.contains(key)) {
            System.out.print("Cannot put duplicate key '" + key + "'");
        } else {
            table.insert(new ListNode<K,V>(key, value));
        }
    }

    public void remove(K key) {
        table.delete(key);
    }

    /**
     *Returns <b style="color: red;">Set</b> of all keys of CustomHashMap */
    public Set<K> keySet() {
        return table.keySet();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet<Node<K,V>>();
    };

    public int size() {
        return table.count();
    }

    public void displayTable() {
        table.displayTable();
    }

    static class Node<K,V> extends ListNode<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    private class EntrySet<E> extends AbstractSet<Map.Entry<K,V>> {

        EntrySet() {}

        @Override
        public int size() {
            return table.count();
        }

        @Override
        public boolean isEmpty() {
            return table.count() == 0;
        }

        @Override
        public boolean contains(Object key) {
            return table.find(key) != null;
        }

        @Override
        public Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator();
        }

        @Override
        public boolean add(Map.Entry<K,V> entry) {
            put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override
        public boolean remove(Object o) {
            remove(o);
            return true;
        }

        @Override
        public void clear() {
            table.clear();
        }

        private class EntryIterator<E> implements Iterator<Map.Entry<K,V>> {
            private Map.Entry<K,V> current;
            private Set<K> keySet = table.keySet();
            private Iterator<K> keyIterator;

            EntryIterator() {
                keyIterator = keySet.iterator();
                current = table.find(keyIterator.next());
            }

            @Override
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            @Override
            public Map.Entry<K,V> next() {
                Map.Entry<K,V> result = current;
                if (hasNext()) {
                    K key = keyIterator.next();
                    current = table.find(key);
                }
                return result;
            }
        }
    }
}
