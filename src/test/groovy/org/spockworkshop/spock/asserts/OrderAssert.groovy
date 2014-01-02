package org.spockworkshop.spock.asserts

import org.spockworkshop.domain.Order
import org.spockworkshop.domain.OrderStatus

class OrderAssert {

    Order actual

    private OrderAssert() {
    }

    static OrderAssert assertThat(Order order) {
        return new OrderAssert(actual: order)
    }

    def OrderAssert hasProducts(int expected) {
        assert actual.products.size() == expected
        return this
    }

    def OrderAssert hasStatus(OrderStatus expected) {
        assert actual.orderStatus == expected
        return this;
    }

    def OrderAssert hasProduct(String expected) {
        assert actual.products.find {it.name == expected}
        return this
    }
}
