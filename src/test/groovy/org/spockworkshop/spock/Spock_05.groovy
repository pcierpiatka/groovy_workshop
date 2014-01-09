package org.spockworkshop.spock

import org.spockworkshop.domain.Order
import org.spockworkshop.domain.OrderStatus
import org.spockworkshop.domain.User
import org.spockworkshop.service.OrderService
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

/**
 * Stub/Mock
 */
class Spock_05 extends Specification {

    @Shared
    User user = new User();

    def "stubbing should be working "() {
        given:
            OrderService orderService = Stub(OrderService)
            orderService.createOrder('1', user) >> new Order(OrderStatus.NEW)
        when:
            Order newOrder = orderService.createOrder('1', user)
        then:
            newOrder.orderStatus == OrderStatus.NEW
    }

    def "stubbing should work with subsequent calls "() {
        given:
            OrderService orderService = Stub(OrderService)
            orderService.getOrderStatus(_) >>> [OrderStatus.NEW, OrderStatus.SHIPMENT]
        when:
            Order order = orderService.createOrder('1', user)
        then:
            orderService.getOrderStatus('1') == OrderStatus.NEW
        when:
            orderService.checkout(order)
        then:
            orderService.getOrderStatus('1') == OrderStatus.SHIPMENT
    }

    def "stub can be defined at creation "() {
        given:
             OrderService orderService = Stub(OrderService) {
                 createOrder('1', user) >> new Order(OrderStatus.NEW)
        }
        when:
            Order order = orderService.createOrder('1', user)
        then:
            order.orderStatus == OrderStatus.NEW
    }

    def "mocking should work" () {
        given:
            OrderService orderService = Mock(OrderService)
        when:
            orderService.createOrder('1', user)
        then:
            1 * orderService.createOrder('1', user)
//           (0..1) * orderService.createOrder('1', user)
//            1 * orderService.createOrder(_,_)      //whatever
//            1 * orderService.createOrder(!'2', user) //not this price
//            1 * orderService.createOrder(*_)     // any argument list including empty list
//            1 * orderService.createOrder(!null, user)  // any non-null argument
//            1 * orderService.createOrder(_ as String, _ as User)
//            _ * orderService./c.*eOrder/('1', user)
//            _ * _._ // 100 % coverage
//            1 * orderService.createOrder({ it  == '1'}, _) //argument capture
    }
    @Ignore
    def "errors should be nice to read" () {
        given:
             OrderService orderService = Mock(OrderService)
        when:
             orderService.createOrder('1', user)
        then:
             2 * orderService.createOrder('1', user)
    }

}
