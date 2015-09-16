package org.spockworkshop.spock

import org.spockworkshop.domain.OrderStatus
import org.spockworkshop.service.OrderService
import spock.lang.Specification


/**
 * Modules (spring)
 *
 * Springframework 4.0
 * org.springframework:spring-test:4.1.0-RELEASE
 * org.springframework:spring-beans:4.1.0-RELEASE
 *
 */
//@ContextConfiguration(locations="spring.xml")
//class Spock_07 extends Specification {
//
//    @Autowired
//    OrderService orderService;
//
//    def "should do integration"() {
//        expect:
//            orderService.getOrderStatus("1") == OrderStatus.NEW
//    }
//
//}