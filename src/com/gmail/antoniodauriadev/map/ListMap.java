package com.gmail.antoniodauriadev.map;

import com.gmail.antoniodauriadev.arraylist.ArrayIndexList;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidEntryException;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidKeyException;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;
import com.gmail.antoniodauriadev.entry.Entry;

public class ListMap<K, V> implements Map<K, V> {

    private ArrayIndexList<Entry<K, V>> list;

    /**Creates a new empty Listmap.*/
    public ListMap() {
        this.list = new ArrayIndexList<>();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public V put(K key, V value) throws InvalidKeyException, InvalidEntryException {
        checkKey(key);
        Entry<K, V> entry = searchEntryByKey(key);
        if(entry != null) {
            V toReturn = entry.getValue();
            checkEntry(entry).setValue(value);
            return toReturn;
        }
        else return null;
    }

    @Override
    public V get(K key) throws InvalidKeyException {
        Entry<K, V> entry = searchEntryByKey(key);
        if (entry != null) {
            return entry.getValue();
        }
        else return null;
    }

    @Override
    public V remove(K key) throws InvalidKeyException {
        Entry<K, V> entry = removeEntryByKey(key);
        if (entry != null) {
            return entry.getValue();
        }
        else return null;
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

    /**Searches an entry by the key.
     * @return The entry if it found the same key, null otherwise.*/
    private Entry<K, V> searchEntryByKey(K key) throws InvalidKeyException {
        checkKey(key);
        for (Entry<K, V> e : this.list) {
            if(e.getKey().equals(key)) {
                return e;
            }
        }
        return null;
    }

    /**Removes an entry by the key.
     * @return The removed entry if it found the same key, null otherwise.*/
    private Entry<K, V> removeEntryByKey(K key) throws InvalidKeyException {
        checkKey(key);
        for (int i = 0; i < this.list.size()-1; i++) {
            if (this.list.get(i).getKey().equals(key)) {
                Entry<K, V> toReturn = this.list.get(i);
                this.list.remove(i);
                return toReturn;
            }
        }
        return null;
    }

    /**Determines whether a key is valid.
     * @throws InvalidKeyException If the key is null.*/
    private void checkKey(K key) {
        if (key == null) throw new InvalidKeyException("Invalid key: null.");
    }

    private MyEntry<K, V> checkEntry(Entry<K, V> entry) throws InvalidEntryException {
        if (entry instanceof MyEntry) {
            return (MyEntry<K, V>) entry;
        }
        else throw new InvalidEntryException();
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

        public V setValue(V value) {
            V oldValue = getValue();
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof MyEntry) {
                MyEntry entry = (MyEntry) object;
                return (entry.getKey() == this.key) && (entry.getValue() == this.value);
            }
            else return false;
        }
    }
}