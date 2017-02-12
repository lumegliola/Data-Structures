package com.gmail.antoniodauriadev.proirityqueue;

import com.gmail.antoniodauriadev.completebinarytree.ArrayListCompleteBinaryTree;
import com.gmail.antoniodauriadev.completebinarytree.CompleteBinaryTree;
import com.gmail.antoniodauriadev.entry.Entry;
import com.gmail.antoniodauriadev.exceptions.priorityqueue.EmptyPriorityQueueException;
import com.gmail.antoniodauriadev.exceptions.entry.InvalidKeyException;
import com.gmail.antoniodauriadev.position.Position;

import java.util.Comparator;

public class HeapPriorityQueue<K, V> implements PriorityQueue<K, V> {

    private CompleteBinaryTree<Entry<K,V>> heap;
    private Comparator<K> comp;

    public HeapPriorityQueue() {
        this.heap = new ArrayListCompleteBinaryTree<>();
        this.comp = new DefaultComparator<>();
    }

    public HeapPriorityQueue(Comparator<K> comparator) {
        this.heap = new ArrayListCompleteBinaryTree<>();
        this.comp = comparator;
    }

    @Override
    public int size() {
        return this.heap.size();
    }

    @Override
    public boolean isEmpty() {
        return this.heap.size() == 0;
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (isEmpty())
            throw new EmptyPriorityQueueException("Priority queue is empty.");
        return heap.root().element();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        checkKey(key);
        Entry<K,V> entry = new MyEntry<>(key, value);
        upHeap(heap.add(entry));
        return entry;
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (isEmpty())
            throw new EmptyPriorityQueueException("Priority queue is empty");
        Entry<K,V> min = heap.root().element();
        if (size() == 1)
            heap.remove();
        else {
            heap.replace(heap.root(), heap.remove());
            downHeap(heap.root());
        }
        return min;
    }

    /**Sets a comparator.*/
    public void setComparator(Comparator<K> comparator) throws IllegalStateException {
        if(!isEmpty())
            throw new IllegalStateException("Priority queue is not empty.");
        this.comp = comparator;
    }

    /**Performs down-heap bubbling.*/
    private void downHeap(Position<Entry<K,V>> r) {
        while (heap.isInternal(r)) {
            Position<Entry<K,V>> s;
            if (!heap.hasRight(r))
                s = heap.left(r);
            else if (comp.compare(heap.left(r).element().getKey(),
                    heap.right(r).element().getKey()) <=0)
                s = heap.left(r);
            else
                s = heap.right(r);
            if (comp.compare(s.element().getKey(), r.element().getKey()) < 0) {
                swap(r, s);
                r = s;
            }
            else
                break;
        }
    }

    /**Performs up-heap bubbling.*/
    private void upHeap(Position<Entry<K,V>> v) {
        Position<Entry<K,V>> u;
        while (!heap.isRoot(v)) {
            u = heap.parent(v);
            if (comp.compare(u.element().getKey(), v.element().getKey()) <= 0)
                break;
            swap(u, v);
            v = u;
        }
    }

    /**Swaps two entries.*/
    private void swap(Position<Entry<K,V>> x, Position<Entry<K,V>> y) {
        Entry<K,V> tmp = x.element();
        heap.replace(x, y.element());
        heap.replace(y, tmp);
    }

    /**Determines whether a given key is valid.*/
    private boolean checkKey(K key) {
        boolean result;
        try {
            result = (comp.compare(key,key) == 0);
        } catch (ClassCastException e) {
            throw new InvalidKeyException();
        }
        return result;
    }

    private static class MyEntry<K,V> implements Entry<K,V> {
        private K key;
        private V value;

        public MyEntry(K key, V value) { this.key = key; this.value = value; }

        public K getKey() { return this.key; }

        public V getValue() { return this.value; }

        public String toString() { return "[" + this.key + ", " + this.value + "]"; }
    }
}