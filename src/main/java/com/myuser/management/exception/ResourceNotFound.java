package com.myuser.management.exception;

public class ResourceNotFound extends RuntimeException
{
    public ResourceNotFound(String message){
        super(message);
    }

}
