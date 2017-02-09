package com.gmail.antoniodauriadev.queue.exceptions;

public class FullQueueException extends RuntimeException {

    public FullQueueException(String err) {
        super(err);
    }

    public FullQueueException() {
        super("The queue is full.");
    }
}
