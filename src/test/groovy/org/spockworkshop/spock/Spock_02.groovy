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
import spock.lang.Unroll

/**
 *  basic
 */
class Spock_02 extends Specification {

    /**
     * Spock is a testing and specification framework for Java and Groovy applications.
     * What makes it stand out from the crowd is its beautiful and highly
     * expressive specification language.
     * Thanks to its JUnit runner,
     * Spock is compatible with most IDEs, build tools, and continuous integration servers.
     * Spock is inspired from JUnit, jMock, RSpec, Groovy, Scala, Vulcans,
     * and other fascinating life forms.
     *
     * Live long and ... may the force be with you;)
     */


    def "Each spock's test need to extends Specification  class"() {
        expect:
        println "Spock lets us to write the specifications that describe expected features"
    }

    def instanceField = "ABC"

    def "Objects stored into instance fields are not shared between feature methods"() {
        given:
        instanceField = "DEF"

        expect:
        instanceField == "DEF"
    }

    def "Instead, every feature method gets its own object"() {
        expect:
        instanceField == "ABC"
    }

    @Shared def sharedField = "This is"

    def "Sometimes you need to share an object between feature methods."() {
        given:
        sharedField = sharedField + " Sparta"
        expect:
        sharedField == "This is Sparta"
    }

    def "To achieve this, declare a @Shared field."() {
        expect:
        sharedField == "This is Sparta"
    }

    /**
     * An expect block is more limited than a then block
     * in that it may only contain conditions and variable definitions.
     * It is useful in situations where it is more natural to describe
     * stimulus and expected response in a single expression.
     *
     * def "given when then style"() {
     *     given:
     *     def someText = "Sparta"
     *     when:
     *     def amazing = someAwesomeService.performMagic()
     *     then:
     *     amazing contains sameText
     * }
     *
     */
    def "to run test we need at least expect"() {
        expect:
            "This is the Sparta".contains("Sparta")
    }

    def "usually we use given/when/then BDD style "() {
        given:
            OrderService orderService = new OrderServiceImpl()
        when:
            Order newOrder = orderService.createOrder("1", new User())
        then:
           newOrder.orderStatus == OrderStatus.NEW
    }

    def "interactions with when/then"() {
        given:
            OrderService orderService = new OrderServiceImpl()
        when:
            Order order = orderService.createOrder("1", new User())
        then:
            order.orderStatus == OrderStatus.NEW
        when:
            orderService.checkout(order)
        then:
            order.orderStatus == OrderStatus.SHIPMENT
    }

    @Shared
    OrderService orderService = new OrderServiceImpl()

    def "handle exception"() {
        when:
            orderService.findOrder("1")
        then:
            thrown(OrderNotFoundException)
            //notThrown() Specifies that no exception of the given type should be  thrown
            //noExceptionThrown() Specifies that no exception should be thrown
            //thrown OrderNotFoundException
            //OrderNotFoundException exception = thrown()
            //exception.message
    }

    def "handle exception details"() {
        given:
        def orderId = "1"
        when:
        orderService.findOrder(orderId)
        then:
        OrderNotFoundException exception = thrown()
//        def exception = thrown(OrderNotFoundException)
        exception.message == "There is no such order ${orderId}"
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