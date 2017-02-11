package com.gmail.antoniodauriadev.proirityqueue;

import com.gmail.antoniodauriadev.exceptions.priorityqueue.EmptyPriorityQueueException;
import com.gmail.antoniodauriadev.exceptions.InvalidKeyException;

public interface PriorityQueue<K, V> {

    /**@return The priority queue' size.*/
    public int size();

    /**@return True if the priority queue is empty.*/
    public boolean isEmpty();

    /**@return An entry with a less key without removing it.*/
    public Entry<K,V> min() throws EmptyPriorityQueueException;

    /**Inserts a key-value' couple.
     * @return The creates entry.*/
    public Entry<K,V> insert(K key, V value) throws InvalidKeyException;

    /**Remove an entry with a less key.
     * @return Removed entry.*/
    public Entry<K,V> removeMin() throws EmptyPriorityQueueException;
}