package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 使用 Expando 实现模拟 + 3
 *
 * @author moqi On 10/27/20 19:09
 */
class A11TestUsingMap extends GroovyTestCase {

    void testMethodA() {
        def text = ''
        def fileMock = [write: { text = it }]

        def testObj = new A09ClassWithDependency()
        testObj.methodA(1, fileMock)
        assertEquals("The value is 1.", text)
    }

}
