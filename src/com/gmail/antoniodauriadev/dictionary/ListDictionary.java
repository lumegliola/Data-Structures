package com.gmail.antoniodauriadev.dictionary;

import com.gmail.antoniodauriadev.arraylist.ArrayIndexList;
import com.gmail.antoniodauriadev.entry.Entry;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidEntryException;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidKeyException;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;

public class ListDictionary<K, V> implements Dictionary<K, V> {

    private ArrayIndexList<Entry<K, V>> list;

    public ListDictionary() {
        list = new ArrayIndexList<>();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Entry<K, V> find(K key) throws InvalidKeyException {
        for (Entry<K, V> e : this.list) {
            if(e.getKey().equals(key))
                return e;
        }
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
        PositionList<Entry<K, V>> entries = new NodePositionList<>();
        for (Entry<K, V> e : this.list) {
            if(e.getKey().equals(key))
                entries.addLast(e);
        }
        return entries;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        Entry<K, V> toReturn = new MyEntry<>(key, value);
        list.add(toReturn);
        return toReturn;
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> entry) throws InvalidEntryException {
        int i = 0;
        for (Entry<K, V> e : this.list){
            if(e == entry) {
                this.list.remove(i);
                return e;
            }
            i++;
        }
        throw new InvalidEntryException();
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        PositionList<Entry<K, V>> entries = new NodePositionList<>();
        for (Entry<K, V> e : this.list){
            entries.addLast(e);
        }
        return entries;
    }

    private void checkKey(K key) throws InvalidEntryException {
        if (key == null)
            throw new InvalidKeyException("key is null.");
    }

    private static class MyEntry<K, V> implements Entry<K, V> {
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
            V prevValue = getValue();
            this.value = value;
            return prevValue;
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
