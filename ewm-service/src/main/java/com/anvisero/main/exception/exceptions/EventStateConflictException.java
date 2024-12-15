package com.anvisero.main.exception.exceptions;

public class EventStateConflictException extends RuntimeException {
    public EventStateConflictException(final String message) {
        super(message);
    }
}
