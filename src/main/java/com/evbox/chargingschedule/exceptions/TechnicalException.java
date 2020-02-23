package com.evbox.chargingschedule.exceptions;

public class TechnicalException extends Exception {
    private final String code;

    public TechnicalException(String code) {
        super(code);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public TechnicalException(String code, String message) {
        super(code + ": " + message);
        this.code = code;
    }

    public TechnicalException(String code, String message, Throwable cause) {
        super(code + ": " + message, cause);
        this.code = code;
    }

    public TechnicalException(String code, Throwable cause) {
        super(code, cause);
        this.code = code;
    }
}
