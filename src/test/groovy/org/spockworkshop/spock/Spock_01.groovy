package org.spockworkshop.spock

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

    def "should have setups and cleanups"() {
        expect:
        'to read nice print lines'
    }
}
