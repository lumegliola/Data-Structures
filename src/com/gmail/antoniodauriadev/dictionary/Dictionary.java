package com.gmail.antoniodauriadev.dictionary;

import com.gmail.antoniodauriadev.entry.Entry;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidEntryException;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidKeyException;

public interface Dictionary<K, V> {

    /**@return The Dictionary's size.*/
    int size();

    /**@return True if the dictionary is empty.*/
    boolean isEmpty();

    /**@return An entry containing the given key, or null if no such entry exists.*/
    Entry<K,V> find(K key) throws InvalidKeyException;

    /**@return An iterator containing all the entries containing the
     * given key, or an empty iterator if no such entries exist.*/
    Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException;

    /**Inserts An item into the dictionary.
     * @return the newly created entry.*/
    Entry<K,V> insert(K key, V value) throws InvalidKeyException;

    /**Removes the given entry from the dictionary.
     * @return The removed entry.*/
    Entry<K,V> remove(Entry<K,V> entry) throws InvalidEntryException;

    /**@return An iterator containing all the entries in the dictionary.*/
    Iterable<Entry<K,V>> entries();
}