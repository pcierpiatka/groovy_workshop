package org.spockworkshop.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String orderId) {
        super("There is no such order " + orderId);
    }
}
