package com.gmail.antoniodauriadev.entry;

public interface Entry<K,V> {

    /**@return Key.*/
    K getKey();

    /**@return Value.*/
    V getValue();

}
