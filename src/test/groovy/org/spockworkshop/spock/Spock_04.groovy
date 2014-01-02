package org.spockworkshop.spock

import groovy.sql.Sql
import org.spockworkshop.domain.Account
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Data Driven Testing (Where)
 */
class Spock_04 extends Specification {

    @Unroll("first #a second #b result #c")
    def "maximum of two numbers with readable unrolling"() {
        expect:
        Math.max(a, b) == c
        //
        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
        // | == ||  only serves to separate input date from output
        //0 | 12 | 12
    }

    @Unroll
    def "maximum #c of #a and #b"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 7, 0]
        b << [5, 0, 0]
        c << [5, 7, 0]
    }

    @Shared
    def sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
    def static staticList = [[3, 5, 4, 5],[7, 0, 4, 7],[0, 0, 4, 0]]

    def setupSpec() {
        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
    }

    def "maximum of two numbers using data provider "() {
        expect:
            Math.max(a, b) == c
        where:
//          [_, a, b, c] << sql.rows("select * from maxdata")
          [a, b, _, c] << staticList

    }

    @Unroll
    def "should be able to use with given/when/then"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(amount)

        then:
        account.balance == remaning

        //Used in a then-block to access an expression's value at the time just
        //before the previous where-block was entered
        //account.balance == old(account.balance) - amount

        where:
        balance | amount  || remaning
          10.0  |  5.0    ||   5.0
           3.0  |  2.0    ||   1.0
    }
}
