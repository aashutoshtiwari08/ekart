package com.wipro.ekartManagemet_1.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
         super("Resouce Not Found");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
