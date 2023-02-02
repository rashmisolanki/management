package com.myuser.management.exception;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message)
    {
        super(message);
    }
}
