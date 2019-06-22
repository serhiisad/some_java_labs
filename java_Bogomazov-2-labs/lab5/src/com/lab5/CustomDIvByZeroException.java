package com.lab5;

public class CustomDIvByZeroException extends Exception{

    public CustomDIvByZeroException(String errorMessage) {
        super( "<<Custom Exception thrown:<<<" + errorMessage + ">>>>>>");
    }
}


