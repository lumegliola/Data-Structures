package com.gmail.antoniodauriadev.datastructures.proirityqueue;

import com.gmail.antoniodauriadev.datastructures.entry.Entry;
import com.gmail.antoniodauriadev.datastructures.exceptions.entry.InvalidKeyException;
import com.gmail.antoniodauriadev.datastructures.exceptions.priorityqueue.EmptyPriorityQueueException;

public interface PriorityQueue<K, V> {

    /**@return Size of the priority queue.*/
    int size();

    /**@return True if the priority queue is empty.*/
    boolean isEmpty();

    /**@return An entry with a less key without removing it.*/
    Entry<K,V> min() throws EmptyPriorityQueueException;

    /**Inserts a key-value couple.
     * @return The creates entry.*/
    Entry<K,V> insert(K key, V value) throws InvalidKeyException;

    /**Remove an entry with a less key.
     * @return Removed entry.*/
    Entry<K,V> removeMin() throws EmptyPriorityQueueException;
}