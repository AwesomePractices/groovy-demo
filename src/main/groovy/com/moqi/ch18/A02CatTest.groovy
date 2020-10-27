package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * Car Test
 *
 * @author moqi On 10/27/20 17:26
 */
class A02CatTest extends GroovyTestCase {

    def car

    void setUp() {
        car = new A01Car()
    }

    void testInitialize() {
        assertEquals(0, car.miles)
    }

    void testDrive() {
        car.drive(10)
        assertEquals(10, car.miles)
    }

    void testDriveNegativeInput() {
        car.drive(-10)
        assertEquals(0, car.miles)
    }

}
