package org.spockworkshop.groovy

import org.spockworkshop.domain.Address

/**
 * Collections
 * Closures
 */
class Groovy_02 extends GroovyTestCase {

    void test01_list() {
        List<String> strings = ['One', 'Two', 'Tree']
        List<JavaPerson> persons = [new JavaPerson('Me'), new JavaPerson('You'), new JavaPerson('Her')]
        def list = []
        list << 1
        list << 2
        list << 3

        assert strings.size() == 3
        assert persons.size() == 3
        assert list.size() == 3
    }

    void test02_array() {
        def integers = [1,2,3] as Integer[]
        def longs = [1,2,3] as Long[]

        assert integers.class == Integer[].class
        assert longs.class == Long[].class
    }

    void test03_range() {
        def alphabet = 'a'..'z'
        def numbers = 1..24
        //def numbers = [1..24] -> it's an array with array 1..24

        assert alphabet.size() == 26
        assert alphabet[0..4] == ['a','b','c','d','e']
        assert numbers.size() == 24
        assert numbers[0..4] == [1,2,3,4,5]
    }

    void test04_maps() {
        def map = [one : 1, two : 2]
        map['tree'] = 3

        assert map.size() == 3
        assert map['two'] == 2
    }

    void test05_closures() {
        def list = ['Rob', 'Ron', 'Elvis', 'Arnold']

        def result = list.findAll {it -> it.startsWith('R')}

        assert result == ['Rob', 'Ron']
    }

    void test06_closures() {
        def myConst = 5
        def incByConst = { num -> num + myConst }

        assert incByConst(10) == 15
    }

    void test07_closures() {
        def persons = [Roman:'PL', Tom:'USA', Borys:'RU'].collect {val -> new JavaPerson(val.key, new Address(val.value))}

        assert persons.size() == 3
        assert persons[0].firstName == 'Roman'
        assert persons[0].address.country == 'PL'
    }

}
