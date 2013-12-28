package org.spockworkshop.spock

import groovy.sql.Sql
import org.junit.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Data Driven Testing (Where)
 */
class Spock_04 extends Specification {

    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }

    @Unroll
    def "maximum of two numbers with default unrolling"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }

    @Unroll("first #a second #b result #c")
    def "maximum of two numbers with readable unrolling"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }

    @Unroll
    def "maximum #c of #a and #b"(a, b, c) {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }

    @Unroll
    def "maximum of two numbers using pipes"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 7, 0]
        b << [5, 0, 0]
        c << [5, 7, 0]
    }

    @Shared
    def sql //= Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    @Ignore
    def "maximum of two numbers using sql "() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << sql.rows("select a, b, c from maxdata")
//      [a, b, _, c] << sql.rows("select * from maxdata")

    }

    def static staticList = [[3, 5, 4, 5],[7, 0, 4, 7],[0, 0, 4, 0]]

    def "maximum of two numbers using static list"() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, _, c] << staticList

    }
}
