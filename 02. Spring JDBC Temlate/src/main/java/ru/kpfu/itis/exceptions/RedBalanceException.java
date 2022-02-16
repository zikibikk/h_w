package ru.kpfu.itis.exceptions;

public class RedBalanceException extends IllegalArgumentException {
    public RedBalanceException() {
    }

    public RedBalanceException(String message) {
        super(message);
    }
}
