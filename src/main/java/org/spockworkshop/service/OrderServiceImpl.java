package org.spockworkshop.service;

import org.spockworkshop.domain.Order;
import org.spockworkshop.domain.OrderStatus;
import org.spockworkshop.domain.User;
import org.spockworkshop.exception.OrderNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private Map<String, Order> orderRepository = new HashMap<>();

    @Override
    public Order createOrder(String orderId, User buyer) {
        Order newOrder = new Order(orderId, buyer);
        newOrder.setOrderStatus(OrderStatus.NEW);
        orderRepository.put(newOrder.getOrderId(), newOrder);
        return newOrder;
    }

    @Override
    public void checkout(Order order) {
        order.setOrderStatus(OrderStatus.SHIPMENT);
        orderRepository.put(order.getOrderId(), order);
    }

    @Override
    public Order findOrder(String orderId) {
        Order order = orderRepository.get(orderId);
        if(order == null) {
            throw new OrderNotFoundException(orderId);
        }
        return order;
    }

    @Override
    public OrderStatus getOrderStatus(String orderId) {
        return findOrder(orderId).getOrderStatus();
    }
}
