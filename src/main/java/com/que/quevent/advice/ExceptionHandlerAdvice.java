package com.que.quevent.advice;

import com.que.quevent.exeptions.AttendeeAlreadyExistsException;
import com.que.quevent.exeptions.AttendeeNotExistsException;
import com.que.quevent.exeptions.EventAlreadyExistsException;
import com.que.quevent.exeptions.EventNotExistsException;
import com.que.quevent.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(EventAlreadyExistsException.class)
    public ResponseEntity<ResponseError> eventAlreadyExistsExceptionHandler(EventAlreadyExistsException e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 409), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EventNotExistsException.class)
    public ResponseEntity<ResponseError> eventNotExistsExceptionHadler(EventNotExistsException e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AttendeeAlreadyExistsException.class)
    public ResponseEntity<ResponseError> attendeeAlreadyExistsExceptionHandler(AttendeeAlreadyExistsException e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 409), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AttendeeNotExistsException.class)
    public ResponseEntity<ResponseError> attendeeNotExistsExceptionHandler(AttendeeNotExistsException e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 404), HttpStatus.NOT_FOUND);
    }
}
