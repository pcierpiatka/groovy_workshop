package org.spockworkshop.groovy

import org.spockworkshop.domain.Address;

class GroovyPerson {

    String firstName
    String lastName
    Address address

    GroovyPerson(String defaultName = 'Anonymous') {
        firstName = defaultName
    }
}
