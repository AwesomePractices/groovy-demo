package com.moqi.ch18

import groovy.mock.interceptor.MockFor
import groovy.test.GroovyTestCase

/**
 * 使用 Groovy Mock Library 实现模拟 + 2
 *
 * @author moqi On 10/27/20 19:09
 */
class A15TestMethodCUsingMock extends GroovyTestCase {

    void testMethodC() {
        def testObj = new A09ClassWithDependency()
        def fileMock = new MockFor(FileWriter)
        def text

        fileMock.demand.write { text = it.toString() }
        fileMock.demand.close {}

        fileMock.use {
            testObj.methodC(1)
        }

        assertEquals("The value is 1.", text)
    }

}
