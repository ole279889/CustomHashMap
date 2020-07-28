package team.mediasoft.study.java.ee.hashmap;

import java.util.*;

public class CustomHashTable<K,V> {
    private CustomLinkedList[] hashArray;
    private int arraySize = 10;
    private int count = 0;
    private double loadFactor = 0.75;

    CustomHashTable() {
        hashArray = new CustomLinkedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new CustomLinkedList();
        }
    }

    public int hashFunc(int key) {
        return Math.abs(key % arraySize);
    }

    public void insert(ListNode<K,V> e) {
        if (count >= getThreshold())
            rehash();
        int key = e.getKey().hashCode();
        int hashVal = hashFunc(key);
        hashArray[hashVal].add(e);
        count++;
    }

    public void delete(Object key) {
        int hashVal = hashFunc(key.hashCode());
        CustomLinkedList list = hashArray[hashVal];
        list.removeByKey(key);
        count--;
    }

    public ListNode<K,V> find(Object key) {
        int hashVal = hashFunc(key.hashCode());
        CustomLinkedList list = hashArray[hashVal];
        return list.getByKey(key);
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println(i + ": ");
            hashArray[i].displayList();
        }
    }

    public int count() {
        return this.count;
    }

    public void clear() {
        this.arraySize = 10;
        this.count = 0;
        hashArray = new CustomLinkedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new CustomLinkedList();
        }
    }

    public Set<K> keySet() {
        return new KeySet();
    }

    private int getThreshold() { //порог заполнения
        return (int)(arraySize * loadFactor);
    }

    private boolean containsKey(Object key) {
        return find(key) != null;
    }

    private void rehash() {
        int newArraySize = (int) (arraySize * 1.5d);
        int oldArraySize = arraySize;
        arraySize = newArraySize;
        CustomLinkedList[] newHashArray = new CustomLinkedList[newArraySize];
        for (int i = 0; i < newArraySize; i++) {
            newHashArray[i] = new CustomLinkedList();
        }
        for (int i = 0; i < oldArraySize; i++) {
            for (int j = 0; j < hashArray[i].size(); j++) {
                int key = hashArray[i].get(j).getKey().hashCode();
                int hashVal = hashFunc(key);
                newHashArray[hashVal].add(hashArray[i].get(j));
            }
        }
        hashArray = newHashArray;
    }

    private class KeySet extends AbstractSet<K> {

        @Override
        public Iterator<K> iterator() {
            return new TableKeyIterator();
        }

        @Override
        public int size() {
            return count;
        }

        @Override
        public boolean contains(Object o) {
            return containsKey(o);
        }

        @Override
        public boolean remove(Object key) {
            delete(key);
            return true;
        }

        @Override
        public void clear() {
            clear();
        }
    }

    private class TableKeyIterator implements Iterator<K> {

        private int currentKeyIndex = -1;
        private K current;
        private ArrayList<K> allKeys;

        TableKeyIterator() {
            allKeys = getAllKeys();
        }

        @Override
        public boolean hasNext() {
            return currentKeyIndex < count - 1;
        }

        @Override
        public K next() {
            K result = current;
            if (hasNext()) {
                currentKeyIndex++;
                current = allKeys.get(currentKeyIndex);
                result = current;
            }
            return result;
        }
    }

    private ArrayList<K> getAllKeys() {
        ArrayList<K> list = new ArrayList<K>();
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < hashArray[i].size(); j++) {
                list.add((K)hashArray[i].get(j).getKey());
            }
        }
        return list;
    }
}
