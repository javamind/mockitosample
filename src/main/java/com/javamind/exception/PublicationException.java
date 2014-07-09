package com.javamind.exception;

/**
 * {@link }
 *
 * @author EHRET_G
 */
public class PublicationException extends RuntimeException {
    public PublicationException() {
    }

    public PublicationException(String message) {
        super(message);
    }

    public PublicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationException(Throwable cause) {
        super(cause);
    }

    public PublicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
