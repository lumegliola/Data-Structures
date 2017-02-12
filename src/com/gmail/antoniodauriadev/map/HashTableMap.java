package com.gmail.antoniodauriadev.map;

import com.gmail.antoniodauriadev.entry.Entry;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidKeyException;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;

import java.util.Random;

public class HashTableMap<K, V> implements Map<K, V> {

    private Entry<K,V> AVAILABLE ;
    private int size;
    private int primeFactor, capacity;
    private Entry<K,V>[] bucket;
    private int scale, shift;

    /**Creates an HashTableMap with primeFactor factor = 109345121 and capacity = 1024.*/
    public HashTableMap(){ this(109345121,1024); }

    /**Creates an HashTableMap with primeFactor factor = 109345121 and chosen capacity.*/
    public HashTableMap(int capacity) { this(109345121, capacity); }

    /**Creates an HashTableMap with chosen primeFactor factor and capacity.*/
    public HashTableMap(int primeFactor, int capacity) {
        this.size = 0;
        this.AVAILABLE = new HashEntry<>(null, null);
        this.primeFactor = primeFactor;
        this.capacity = capacity;
        this.bucket = (Entry<K,V>[]) new Entry[this.capacity];
        Random rand = new Random();
        this.scale = rand.nextInt(this.primeFactor -1) + 1;
        this.shift = rand.nextInt(this.primeFactor);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public V put(K key, V value) throws InvalidKeyException {
        int i = findEntry(key); //find the appropriate spot for this entry
        if (i >= 0)	//  this key has a previous value
            return ((HashEntry<K,V>) this.bucket[i]).setValue(value); // set new value
        if (size() >= this.capacity/2) {
            rehash(); // rehash to keep the load factor <= 0.5
            i = findEntry(key); //find again the appropriate spot for this entry
        }
        this.bucket[-i-1] = new HashEntry<>(key, value); // convert to proper index
        this.size++;
        return null; 	// there was no previous value
    }

    @Override
    public V get(K key) throws InvalidKeyException {
        int i = findEntry(key);
        if (i < 0)
            return null;

        return this.bucket[i].getValue();
    }

    @Override
    public V remove(K key) throws InvalidKeyException {
        int i = findEntry(key);  	// find this key first
        if (i < 0) return null;  	// nothing to remove
        V toReturn = this.bucket[i].getValue();
        this.bucket[i] = this.AVAILABLE; 		// mark this slot as deactivated
        this.size--;
        return toReturn;
    }

    @Override
    public Iterable<K> keys() {
        PositionList<K> keys = new NodePositionList<>();
        for (int i=0; i < capacity; i++)
            if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
                keys.addLast(bucket[i].getKey());
        return keys;
    }

    @Override
    public Iterable<V> values() {
        PositionList<V> values = new NodePositionList<>();
        for (int i=0; i < capacity; i++)
            if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
                values.addLast(bucket[i].getValue());
        return values;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        PositionList<Entry<K, V>> entries = new NodePositionList<>();
        for (int i=0; i < capacity; i++)
            if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
                entries.addLast(bucket[i]);
        return entries;
    }

    /** Determines whether a key is valid.
     * @throws InvalidKeyException If the key is null.*/
    private void checkKey(K k) {
        if (k == null) throw new InvalidKeyException("The key is null.");
    }

    /** Hash function applying MAD method to default hash code. */
    private int hashValue(K key) {
        return ((Math.abs(key.hashCode()*scale + shift) % primeFactor)%capacity);
    }

    /**Helper search method - returns index of found key or -(a + 1),
     * where a is the index of the first empty or available slot found.*/
    private int findEntry(K key) throws InvalidKeyException {
        int avail = -1;
        checkKey(key);
        int i = hashValue(key);
        int j = i;
        do {
            Entry<K,V> e = bucket[i];
            if ( e == null) {
                if (avail < 0)
                    avail = i;	// key is not in table
                break;
            }
            if (key.equals(e.getKey())) // we have found our key
                return i;	// key found
            if (e == AVAILABLE) {	// bucket is deactivated
                if (avail < 0)
                    avail = i;	// remember that this slot is available
            }
            i = (i + 1) % capacity;	// keep looking
        } while (i != j);
        return -(avail + 1);  // first empty or available slot
    }

    /**Doubles the size of the hash table and rehashes all the entries.*/
    private void rehash() {
        capacity = 2*capacity;
        Entry<K,V>[] old = bucket;
        bucket = (Entry<K,V>[]) new Entry[capacity]; // new bucket is twice as big
        java.util.Random rand = new java.util.Random();
        scale = rand.nextInt(capacity-1) + 1;    	// new hash scaling factor
        shift = rand.nextInt(capacity); 		// new hash shifting factor
        for (Entry<K, V> e : old) {
            if ((e != null) && (e != AVAILABLE)) { // a valid entry
                int j = -1 - findEntry(e.getKey());
                bucket[j] = e;
            }
        }
    }

    private static class HashEntry<K,V> implements Entry<K,V> {
        private K key;
        private V value;

        HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return this.value;
        }

        public K getKey() {
            return this.key;
        }

        private V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object object) {
            if (object instanceof HashEntry) {
                HashEntry entry = (HashEntry) object;
                return (entry.getKey() == this.key) && (entry.getValue() == this.value);
            }
            else return false;
        }
    }
}