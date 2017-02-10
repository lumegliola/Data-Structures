package com.gmail.antoniodauriadev.exceptions.queue;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(String err) {
        super(err);
    }

    public EmptyQueueException() {
        super("The queue is empty.");
    }
}
