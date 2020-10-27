package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 使用 Expando 实现模拟 + 1
 *
 * @author moqi On 10/27/20 19:06
 */
class A10TestWithExpando extends GroovyTestCase {

    void testMethodA() {
        def testObj = new A09ClassWithDependency()
        def fileMock = new HandTossedFileMock()

        testObj.methodA(1, fileMock)

        assertEquals("The value is 1.", fileMock.result)
    }

}

class HandTossedFileMock {
    def result
    def write(value) {result = value}
}