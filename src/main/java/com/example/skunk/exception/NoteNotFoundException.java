package com.example.skunk.exception;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException() {
        super();
    }
    public NoteNotFoundException(String message) {
        super(message);
    }
}
