package com.gmail.antoniodauriadev.exceptions.priorityqueue;

public class EmptyPriorityQueueException extends RuntimeException {

    public EmptyPriorityQueueException() {
        super("The key is invalid.");
    }

    public EmptyPriorityQueueException(String error) {
        super(error);
    }

}