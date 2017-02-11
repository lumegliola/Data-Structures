package com.gmail.antoniodauriadev.proirityqueue;

import com.gmail.antoniodauriadev.exceptions.priorityqueue.EmptyPriorityQueueException;
import com.gmail.antoniodauriadev.exceptions.priorityqueue.InvalidKeyException;
import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;

import java.util.Comparator;

public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {

    private PositionList<Entry<K,V>> entries;
    private Comparator<K> comparator;

    /** Crea la coda a priorita` con il comparatore di default. */
    public SortedListPriorityQueue () {
        entries = new NodePositionList<>();
        comparator = new DefaultComparator<>();
    }

    /** Crea la coda a priorita` con un dato comparatore. */
    public SortedListPriorityQueue (Comparator<K> comp) {
        entries = new NodePositionList<>();
        comparator = comp;
    }

    /** Crea la coda a priorita` con un dato comparatore e una data lista.
     * Si assume che gli elementi della lista siano in ordine non decrescente.*/
    public SortedListPriorityQueue (PositionList<Entry<K,V>> list, Comparator<K> comp) {
        entries = list;
        comparator = comp;
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (entries.isEmpty())
            throw new EmptyPriorityQueueException("priority queue is empty.");
        else
            return entries.first().element();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        checkKey(key);
        Entry<K,V> entry = new MyEntry<>(key, value);
        insertEntry(entry);
        return entry;
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (entries.isEmpty())
            throw new EmptyPriorityQueueException("priority queue is empty.");
        else
            return entries.remove(entries.first());
    }

    /**Auxiliary method for the insertion of entries.*/
    private void insertEntry(Entry<K, V> e) {
        for (Position<Entry<K,V>> posentry : entries.positions())
            if (comparator.compare(e.getKey(), posentry.element().getKey()) <= 0){
                entries.addBefore(posentry, e);
                return;
            }
        entries.addLast(e);
    }

    /**Sets the comparator.
     * @throws IllegalStateException If the queue is not empty.*/
    public void setComparator(Comparator<K> comp) throws IllegalStateException {
        if(!isEmpty())
            throw new IllegalStateException("The queue is not empty.");
        comparator = comp;
    }

    /**Determines the key's validity.*/
    private boolean checkKey(K key) throws InvalidKeyException {
        boolean result;
        try {
            result = (comparator.compare(key,key) == 0);
        } catch (ClassCastException e) {
            throw new InvalidKeyException();
        }
        return result;
    }

    /**Internal class for the entries.*/
    private static class MyEntry<K,V> implements Entry<K,V> {
        private K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return this.key; }

        public V getValue() { return this.value; }
    }

}