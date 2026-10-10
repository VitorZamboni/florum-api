package br.com.florum.error.exceptions;

public class UnprocessableException extends RuntimeException{
    public UnprocessableException(String message){
        super(message);
    }
}
