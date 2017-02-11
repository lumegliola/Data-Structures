package com.gmail.antoniodauriadev.map;

import com.gmail.antoniodauriadev.arraylist.ArrayIndexList;
import com.gmail.antoniodauriadev.exceptions.InvalidKeyException;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;
import com.gmail.antoniodauriadev.proirityqueue.Entry;

public class ListMap<K, V> implements Map<K, V> {

    private ArrayIndexList<Entry<K, V>> list;

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public V put(K key, V value) throws InvalidKeyException {
        return null;
    }

    @Override
    public V get(K key) throws InvalidKeyException {
        return null;
    }

    @Override
    public V remove(K key) throws InvalidKeyException {
        return null;
    }

    @Override
    public Iterable<K> keys() {
        PositionList<K> keys = new NodePositionList<>();
        for (Entry<K, V> e : this.list)
            keys.addLast(e.getKey());
        return keys;
    }

    @Override
    public Iterable<V> values() {
        PositionList<V> values = new NodePositionList<>();
        for (Entry<K, V> e : this.list)
            values.addLast(e.getValue());
        return values;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        PositionList<Entry<K,V>> entries = new NodePositionList<>();
        for (Entry<K, V> e : this.list)
                entries.addLast(e);
        return entries;

    }


    private static class MyEntry<K, V> implements Entry<K,V> {

        private K key;
        private V value;

        MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }
}