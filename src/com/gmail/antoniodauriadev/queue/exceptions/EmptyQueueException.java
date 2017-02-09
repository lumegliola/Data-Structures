package com.gmail.antoniodauriadev.queue.exceptions;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException(String err) {
        super(err);
    }

    public EmptyQueueException() {
        super("The queue is empty.");
    }
}
