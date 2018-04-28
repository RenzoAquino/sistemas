package com.sisint.common.exceptions;


public class BusinessException extends Throwable {

    private static final long serialVersionUID = 1L;
    public BusinessException(){
        super();
    }
    public BusinessException(String message){
        super(message);
    }
}