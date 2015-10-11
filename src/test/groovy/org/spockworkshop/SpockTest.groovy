package org.spockworkshop

import org.junit.Assert
import org.spockworkshop.domain.Order
import org.spockworkshop.domain.OrderStatus
import org.spockworkshop.domain.Product
import org.spockworkshop.service.OrderService
import org.spockworkshop.service.OrderServiceImpl
import spock.lang.Shared
import spock.lang.Specification


class SpockTest extends Specification {

    @Shared
    OrderService orderService = new OrderServiceImpl()

    def "should checkout order"() {
        given:
        Order order = new Order(products:
                [new Product("Door"), new Product("Window"), new Product("Chair")])

        when:
        orderService.checkout(order)

        then:
        with(order) {
            orderStatus == OrderStatus.SHIPMENT
            products.size() == 3
        }
    }

    def "dasdsa"() {
        given:
        //arrange
        Order order = new Order();

        List<Product> products = new ArrayList<>();
        products.add(new Product("Door"));
        products.add(new Product("Window"));
        products.add(new Product("Chair"));

        order.add(products);
        OrderService orderService = new OrderServiceImpl();
        when:
        //act
        orderService.checkout(order);

        then:
        //assert
        def  a = 2
        order.getOrderStatus() == OrderStatus.SHIPMENT
        Assert.assertEquals(order.getProducts().size(), 3);
        a == 2
    }

}