package com.gmail.antoniodauriadev.entry;

public interface Entry<K,V> {

    /**@return The key.*/
    K getKey();

    /**@return The Value.*/
    V getValue();

}
