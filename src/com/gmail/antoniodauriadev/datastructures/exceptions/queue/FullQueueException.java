package com.gmail.antoniodauriadev.datastructures.exceptions.queue;

public class FullQueueException extends RuntimeException {

    public FullQueueException(String err) {
        super(err);
    }

    public FullQueueException() {
        super("The queue is full.");
    }
}
