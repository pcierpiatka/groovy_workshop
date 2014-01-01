package org.spockworkshop.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;
    private List<Product> products = new ArrayList<Product>();
    private User buyer;
    private OrderStatus orderStatus;

    public Order(){
        //empty
    }

    public Order(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(String orderId, User buyer) {
        this.orderId = orderId;
        this.buyer = buyer;
    }

    public BigDecimal totalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        if(!products.isEmpty()) {
            for(Product product : products) {
                total.add(product.getPrice());
            }
        }
        return total;
    }

    public int numberOfProduct() {
        return products.size();
    }

    public void add(Product product) {
        products.add(product);
    }

    public void add(List<Product> products){
        this.products.addAll(products);
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

  public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
