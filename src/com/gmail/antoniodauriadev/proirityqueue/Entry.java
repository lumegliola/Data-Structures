package com.gmail.antoniodauriadev.proirityqueue;

public interface Entry<K,V> {

    /**@return The key.*/
    public K getKey();
    /**@return The Value.*/
    public V getValue();

}
