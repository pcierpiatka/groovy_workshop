package org.spockworkshop.service;

import org.spockworkshop.domain.Order;
import org.spockworkshop.domain.OrderStatus;
import org.spockworkshop.domain.User;

public interface OrderService {

    Order createOrder(String orderId, User buyer);

    void checkout(Order order);

    Order findOrder(String orderId);

    OrderStatus getOrderStatus(String orderId);

    int orderIdForSomeImportantThing();

}
