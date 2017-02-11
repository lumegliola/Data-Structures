package com.gmail.antoniodauriadev.map;

import com.gmail.antoniodauriadev.exceptions.InvalidKeyException;
import com.gmail.antoniodauriadev.proirityqueue.Entry;

public interface Map<K, V> {

    /**@return The map's size.*/
    int size();

    /**@return True if the map is empty.*/
    boolean isEmpty();

    /**Adds a Key/Value couple.
     * @return The previous value with that key. Null if the key si new.*/
    V put(K key, V value) throws InvalidKeyException;

    /**@return The value associate to the key. Null if the key isn't in the map.*/
    V get(K key) throws InvalidKeyException;

    /**Removes a Key/Value couple.
     * @return Removed value.*/
    V remove(K key) throws InvalidKeyException;

    /**@return An Iterable keys' collection.*/
    Iterable<K> keys();

    /**@return An Iterable values' collection.*/
    Iterable<V> values();

    /**@return An Iterable entries' collection.*/
    Iterable<Entry<K,V>> entries();
}