package com.example.employeefilter.exception;

public class WrongUserNameOrPasswordException extends Exception{
    public WrongUserNameOrPasswordException(){
        super();
    }

    public WrongUserNameOrPasswordException(String message) {
        super(message);
    }
}