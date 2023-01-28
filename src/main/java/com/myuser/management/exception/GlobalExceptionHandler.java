package com.myuser.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> ResourceNotFound(ResourceNotFound ex, WebRequest webRequest)
    {
        ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(), webRequest.getDescription(false));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }
}

