package com.gmail.antoniodauriadev.datastructures.map;

import com.gmail.antoniodauriadev.datastructures.entry.Entry;
import com.gmail.antoniodauriadev.datastructures.exceptions.entry.InvalidKeyException;

public interface Map<K, V> {

    /**@return Size of the map.*/
    int size();

    /**@return True if the map is empty.*/
    boolean isEmpty();

    /**Adds a Key/Value couple.
     * @return Previous value with that key. Null if the key is new.*/
    V put(K key, V value) throws InvalidKeyException;

    /**@return Value associate to the key. Null if the key isn't in the map.*/
    V get(K key) throws InvalidKeyException;

    /**Removes a Key/Value couple.
     * @return Removed value.*/
    V remove(K key) throws InvalidKeyException;

    /**@return An Iterable collection of the keys.*/
    Iterable<K> keys();

    /**@return An Iterable collection of the values.*/
    Iterable<V> values();

    /**@return An Iterable collection of the entries.*/
    Iterable<Entry<K,V>> entries();
}