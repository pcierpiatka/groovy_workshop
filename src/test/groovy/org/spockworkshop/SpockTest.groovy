package org.spockworkshop

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
        Order order = new Order();
        order.products = [new Product("Door"), new Product("Window"), new Product("Chair")]

        when:
        orderService.checkout(order);

        then:
        with(order) {
            orderStatus == OrderStatus.SHIPMENT
            products.size() == 3
        }
    }
}
