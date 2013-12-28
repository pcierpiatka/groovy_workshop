package org.spockworkshop.groovy

import org.spockworkshop.domain.Address

/**
 * JavaPojo
 * GroovyPojo
 */
class Groovy_04 extends GroovyTestCase {
    void test01_construction() {

        JavaPerson elvis = new JavaPerson(firstName:'Elvis',lastName:'Presley')
        JavaPerson wiolleta = new JavaPerson('Violetta', 'Villas', new Address('PL'))

        JavaPerson cos = new JavaPerson(firstName: "Roman", lastName: "Otton")

        GroovyPerson brian = new GroovyPerson(firstName: 'Brian', lastName: 'Johnson', address: new Address('USA'))
        GroovyPerson frank = new GroovyPerson(firstName : 'Frank')
        GroovyPerson german = new GroovyPerson(address: new Address('GER'))

        assert elvis.firstName == 'Elvis'
        assert wiolleta.firstName == 'Wiolleta'
        assert frank.firstName == 'Frank'
        assert brian.firstName == 'Brian'
        assert german.address.country == 'GER'
        assert cos.firstName == 'Roman'
    }

    void test02_defaultValues() {
        GroovyPerson anonymous = new GroovyPerson()

        assert  anonymous.firstName == 'Anonymous'
    }

    void test03_with() {

        GroovyPerson person = new GroovyPerson()
        person.with {
            firstName = 'Ron'
            lastName = 'Romanski'
        }

        assert person.firstName == 'Ron'
    }
}
