package org.spockworkshop.spock

import spock.lang.Ignore
import spock.lang.Specification

/**
 * Test setup
 */
class Spock_01 extends Specification {

    def setup() {
        println '@Before'
    }

    def setupSpec() {
        println '@BeforeClass'
    }

    def cleanup() {
        println '@After'
    }

    def cleanupSpec() {
        println '@AfterClass'
    }

    def "all kind of blocks "() {
//        given: "preconditions, data fixtures"
//        setup: "alias for given (JUnit syntax)"
//        when: "actions that trigger some outcome"
//        then: "make assertions about the outcome"
//        where: "applies varied inputs"
//        and: "subdivides other blocks"
//        cleanup: "post-conditions, housekeeping"
        expect: "shorthand for when & then"
    }
}
