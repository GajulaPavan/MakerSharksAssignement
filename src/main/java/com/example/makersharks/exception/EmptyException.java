package com.example.makersharks.exception;

public class EmptyException extends RuntimeException{
	private String customMessage;

    public EmptyException(String customMessage) {
        super(customMessage);
        this.customMessage = customMessage;
    }

    public EmptyException(String customMessage, Throwable cause) {
        super(customMessage, cause);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

}
