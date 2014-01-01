package org.spockworkshop.groovy

import org.spockworkshop.domain.Address

/**
 * JavaPojo
 * GroovyPojo
 */
class Groovy_03 extends GroovyTestCase {

    void test01_construction() {

        JavaPerson elvis = new JavaPerson('Elvis', 'Presley')
        JavaPerson violetta = new JavaPerson('Violetta', 'Villas', new Address('PL'))

        GroovyPerson brian = new GroovyPerson(firstName: 'Brian', lastName: 'Johnson', address: new Address('USA'))
        GroovyPerson frank = new GroovyPerson(firstName : 'Frank')
        GroovyPerson german = new GroovyPerson(address: new Address('GER'))

        assert elvis.firstName == 'Elvis'
        assert violetta.firstName == 'Violetta'
        assert frank.firstName == 'Frank'
        assert brian.firstName == 'Brian'
        assert german.address.country == 'GER'
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
