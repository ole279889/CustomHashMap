package team.mediasoft.study.java.ee.hashmap;

import java.util.Map;

public class ListNode<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    ListNode() {}

    ListNode(K key, V value) {
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
