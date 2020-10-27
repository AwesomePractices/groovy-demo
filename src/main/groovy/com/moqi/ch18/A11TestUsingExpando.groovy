package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 使用 Expando 实现模拟 + 2
 *
 * @author moqi On 10/27/20 19:09
 */
class A11TestUsingExpando extends GroovyTestCase {

    void testMethodA() {
        def fileMock = new Expando(text: '', write: {text = it})

        def testObj = new A09ClassWithDependency()
        testObj.methodA(1, fileMock)
        assertEquals("The value is 1.", fileMock.text)
    }

}
