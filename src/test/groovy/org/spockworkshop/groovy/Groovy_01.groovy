package org.spockworkshop.groovy

import org.spockworkshop.domain.Address

/**
 * GString
 * Elvis
 * Regular expressions as booleans
 */
class Groovy_01 extends GroovyTestCase {

    void test01_GString() {
        def hello = 'This is "Sparta"'

        assert hello.contains('Sparta')
    }

    void test02_GString() {
        def king = 'Leonidas'
        def message = "The king ${king} and his ${150 + 150} Spartans"

        assert message == 'The king Leonidas and his 300 Spartans'
    }
    /**
     * GString and String are two distinct classes
     * GString and a String won't have the same hashCode nor will they be equal.
     * There is no automatic coercion between the two types for comparisons or map
     * keys, so it's sometimes necessary to explicitly invoke toString() on GString objects.
     */
    void test03_GStringTrap() {
        Map<String, Integer> map = new HashMap()
        map.put("One ${1}", 1)
        map.put('One 1', 1)

        assert map.toMapString() == '[One 1:1, One 1:1]'
        assert map.size() == 2

    }

    void test04_elvis() {
        JavaPerson elvis = new JavaPerson("Elvis")
        //java style
        String displayNameJava = elvis.getLastName() != null ? elvis.getLastName() : elvis.getFirstName()
        //groovy style
        def displayNameElvis = elvis.getLastName()?: elvis.getFirstName()

        assert displayNameJava == "Elvis"
        assert displayNameElvis == "Elvis"
    }

    void test05_elvis() {
        JavaPerson elvis = new JavaPerson("Elvis", new Address("USA"))

        def javaDisplayCountry = 'undefined'
        //java style
        if(elvis.getAddress() != null && elvis.getAddress().getCountry() != null) {
            javaDisplayCountry = elvis.getAddress().getCountry()
        }
        //groovy style
        def groovyDisplayCountry = elvis?.address?.country

        assert javaDisplayCountry == 'USA'
        assert groovyDisplayCountry == 'USA'
    }

    void test06_booleanExpression() {
        def message = null

        assert message.asBoolean() == false

        if(!message) {
            message = 'This is Sparta'
        }

        assert message == 'This is Sparta'
    }

    void test07_booleanExpression() {
        List<String> list = Arrays.asList();
        Map map = new HashMap();

        assert list.asBoolean() == false
        assert map.asBoolean() == false
    }

}
