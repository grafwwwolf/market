package ru.pigarev.market.exceptions;

public class CartExistProductException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CartExistProductException(String message) {
        this.message = message;
    }
}
