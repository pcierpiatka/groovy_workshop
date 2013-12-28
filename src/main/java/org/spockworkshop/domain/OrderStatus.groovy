package org.spockworkshop.domain

public enum OrderStatus {
    NEW,
    SHIPMENT,
    WAITING_FOR_PAYMENT,
    FINISHED;
}