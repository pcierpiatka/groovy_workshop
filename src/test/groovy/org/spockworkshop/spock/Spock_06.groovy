package org.spockworkshop.spock

import org.assertj.core.api.Assertions
import org.spockworkshop.domain.Order
import org.spockworkshop.domain.OrderStatus
import org.spockworkshop.domain.Product
import org.spockworkshop.service.OrderService
import org.spockworkshop.service.OrderServiceImpl
import spock.lang.Shared
import spock.lang.Specification

import static org.spockworkshop.spock.asserts.OrderAssert.assertThat

/**
 * Assert
 */
class Spock_06 extends Specification {

    @Shared
    OrderService orderService = new OrderServiceImpl()

    def "simply assert"() {
        given:
            Order order = new Order()
            order.products = [new Product("Door"), new Product("Window"), new Product("Chair")]

        when:
            orderService.checkout(order)

        then:
           assertThat(order).hasProducts(3).hasStatus(OrderStatus.SHIPMENT).hasProduct("Window")
//           assertThat order hasProducts 3 hasStatus OrderStatus.SHIPMENT hasProduct "Window"
//           Assertions.assertThat(order.products).hasSize(3)
//           Assertions.assertThat order.products hasSize 3
    }



}
