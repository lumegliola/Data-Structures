package com.gmail.antoniodauriadev.queue;

class FullQueueException extends RuntimeException {

    FullQueueException(String err) {
        super(err);
    }

    FullQueueException() {
        super("The queue is full.");
    }
}
