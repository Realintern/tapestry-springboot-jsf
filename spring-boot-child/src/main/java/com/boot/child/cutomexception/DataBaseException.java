package com.boot.child.cutomexception;


/**
 * Created by manukg on 9/19/2016.
 */
public class DataBaseException extends Exception {
    public DataBaseException(){}
    public DataBaseException(String message){
        super(message);
    }
    public DataBaseException(Throwable throwable){
        super(throwable);
    }
    public DataBaseException(String message,Throwable throwable){
        super(message,throwable);
    }

}
