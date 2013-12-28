package org.spockworkshop.spock

import org.junit.Ignore
import spock.lang.IgnoreIf
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

/**
 * Extension
 */
class Spock_03 extends Specification {

    @Ignore("because TODO")
    def "should have ignore"() {
        expect:
        false
    }

    @IgnoreRest
    def "should ignore everything except for this"() {
        expect:
        true
    }


    @IgnoreIf({ System.getProperty("os.name").contains("windows") })
    //@Requires({ System.getProperty("os.name").contains("linux") })
    def "should be ignored on windows"() {
        expect:
        false
    }

   @Stepwise
   class Stepwise_test extends Specification {
       def "I should be run first"() {}
       def "I should be run second"() {}
   }

   @Timeout(value = 5 , unit = TimeUnit.SECONDS)
   //@Timeout(5)
   def "should be file if run more than 5 second"() {}


}
