package com.n26.ws.exceptions;

/**
 * @author abhishekrai
 * @since 0.0.1
 */
public class InvalidTimestampException extends IllegalArgumentException {

    public InvalidTimestampException(String message) {
        super(message);
    }

    public static void check(boolean condition,
                             String message,
                             Object... args) {
        if (!condition) {
            throw new InvalidTimestampException(String.format(message,
                                                              args));
        }
    }
}