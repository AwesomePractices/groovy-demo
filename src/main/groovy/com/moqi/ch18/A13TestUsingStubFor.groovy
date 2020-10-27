package com.moqi.ch18

import groovy.mock.interceptor.StubFor
import groovy.test.GroovyTestCase

/**
 * 使用 Groovy Mock Library 实现模拟
 *
 * @author moqi On 10/27/20 19:09
 */
class A13TestUsingStubFor extends GroovyTestCase {

    void testMethodB() {
        def testObj = new A09ClassWithDependency()
        def fileMock = new StubFor(FileWriter)
        def text

        fileMock.demand.write {text = it.toString()}
        fileMock.demand.close {}

        fileMock.use {
            testObj.methodB(1)
        }

        assertEquals("The value is 1.", text)
    }

}
