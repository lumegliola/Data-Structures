package com.gmail.antoniodauriadev.datastructures.exceptions.queue;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(String err) {
        super(err);
    }

    public EmptyQueueException() {
        super("The queue is empty.");
    }
}
