package org.spockworkshop;

import org.junit.Assert;
import org.junit.Test;
import org.spockworkshop.domain.Order;
import org.spockworkshop.domain.OrderStatus;
import org.spockworkshop.domain.Product;
import org.spockworkshop.service.OrderService;
import org.spockworkshop.service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class JUnitTest {

    @Test
    public void shouldCheckoutOrder() {
        //given
        //arrange
        Order order = new Order();

        List<Product> products = new ArrayList<>();
        products.add(new Product("Door"));
        products.add(new Product("Window"));
        products.add(new Product("Chair"));

        order.add(products);
        OrderService orderService = new OrderServiceImpl();

        //when
        //act
        orderService.checkout(order);

        //then
        //assert
        Assert.assertEquals(order.getOrderStatus(), OrderStatus.SHIPMENT);
        Assert.assertEquals(order.getProducts().size(), 3);
    }
}
