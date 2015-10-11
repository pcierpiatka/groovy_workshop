package org.spockworkshop.spock

import org.junit.Ignore
import spock.lang.*

@See("http://spockframework.github.io/spock/docs/1.0/extensions.html")
class Spock_03 extends Specification {

    @IgnoreRest
    def "should ignore everything except for this"() {
        expect:
        true
    }

    @Requires({ os.linux || os.macOs  })
    def "should use fancy text console features"() { expect: true}


//   @Timeout(value = 5 , unit = TimeUnit.SECONDS)
    @Timeout(5)
    def "should fail if run more than 5 second"() {
       expect:
       Thread.sleep(6000)
    }

    @Ignore("because TODO")
    def "should have ignore"() {
        expect:
        false
    }

    @IgnoreIf({ os.windows})
    //@Requires({ System.getProperty("os.name").contains("linux") })
    def "should be ignored on windows"() {
        expect:
        false
    }

    @See("JUnit @Test(dependsOnMethods = { \"step 1\"})")
    @Stepwise
    class Spock_03_a extends Specification {

        def "step 3"() {
            println "3"
            expect: true
        }

        def "step 1"() {
            println "1"
            expect: true
        }

        def "step 2"() {
            println "2"
            expect: true
        }

    }

    @Narrative("A long time ago in a galaxy far, far away...")
    @Title("This is example of some important specification")
    class Spock_03_b extends Specification {

        @Issue("http://my.issues.org/FOO-2")
        def "Foo should do bar"() { expect:true }

        @Issue(["http://my.issues.org/FOO-3", "http://my.issues.org/FOO-4"])
        def "I have two related issues"() {expect:true }

    }

}