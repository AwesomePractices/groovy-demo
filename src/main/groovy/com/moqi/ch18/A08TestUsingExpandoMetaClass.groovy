package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 使用 ExpandoMetaClass 实现模拟
 *
 * @author moqi On 10/27/20 17:56
 */
class A08TestUsingExpandoMetaClass extends GroovyTestCase {

    void testMyMethod() {
        def result

        def emc = new ExpandoMetaClass(CodeWithHeavierDependencies, true)
        emc.println = { text -> result = text }
        emc.someAction = { -> 25 }
        emc.initialize()

        def testObj = new CodeWithHeavierDependencies()
        testObj.metaClass = emc

        testObj.myMethod()
        assertEquals(35, result)
    }

}
