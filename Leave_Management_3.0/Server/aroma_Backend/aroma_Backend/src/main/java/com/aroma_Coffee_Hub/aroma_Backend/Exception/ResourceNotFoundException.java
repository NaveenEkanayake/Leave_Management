package com.aroma_Coffee_Hub.aroma_Backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends  RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
