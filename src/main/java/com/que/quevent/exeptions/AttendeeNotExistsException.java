package com.que.quevent.exeptions;

public class AttendeeNotExistsException extends RuntimeException {
    public AttendeeNotExistsException(String message) {
        super(message);
    }
}
