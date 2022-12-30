package com.springapi.farhadcodesacpblog.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Class clazz, String key, String value) {
        super(clazz.getSimpleName()+" not found with "+key+" "+value);
    }
}
