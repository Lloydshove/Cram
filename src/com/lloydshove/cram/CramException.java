package com.lloydshove.cram;

public class CramException extends RuntimeException {
    public CramException(String reason, Throwable throwable) {
        super(reason, throwable);
    
    }
}
