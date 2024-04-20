package com.que.quevent.exeptions;

public class EventNotExistsException extends RuntimeException {
    public EventNotExistsException(String message) {
        super(message);
    }
}
