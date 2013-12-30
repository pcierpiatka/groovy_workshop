package org.spockworkshop.spock

import org.spockworkshop.domain.Order
import org.spockworkshop.domain.OrderStatus
import org.spockworkshop.domain.User
import org.spockworkshop.exception.OrderNotFoundException
import org.spockworkshop.service.OrderService

import org.spockworkshop.service.OrderServiceImpl
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

/**
 *  basic
 */
class Spock_02 extends Specification {

    @Shared
    OrderService orderService = new OrderServiceImpl();

    def "to run test we need at least expect"() {
        expect:
            "This is the Sparta".contains("Sparta")
    }

    def "usually we use given/when/then "() {
        given:
            OrderService orderService = new OrderServiceImpl();
        when:
            Order newOrder = orderService.createOrder("1", new User())
        then:
            newOrder.orderStatus == OrderStatus.NEW
    }

    def "interactions with when/then "() {
        given:
            OrderService orderService = new OrderServiceImpl();
        when:
            Order order = orderService.createOrder("1", new User())
        then:
            order.orderStatus == OrderStatus.NEW
        when:
            orderService.checkout(order)
        then:
            order.orderStatus == OrderStatus.SHIPMENT
    }

    def "handle exception"() {
        when:
            orderService.findOrder("1")
        then:
            thrown(OrderNotFoundException)
    }

    @Ignore
    def "readable error message"() {
        expect:
            'To be' == 'or not to be'
    }

    @Ignore
    def "readable error cd"() {
        given:
            Map<String, String> maps = [beer : [dark : "Guinness", white : "Heineken" ]]
        expect:
            maps.beer.dark == 'Heineken'
    }
}