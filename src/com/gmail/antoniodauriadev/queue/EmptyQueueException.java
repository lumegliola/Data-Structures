package com.gmail.antoniodauriadev.queue;

class EmptyQueueException extends RuntimeException {

    EmptyQueueException(String err) {
        super(err);
    }

    EmptyQueueException() {
        super("The queue is empty.");
    }
}
