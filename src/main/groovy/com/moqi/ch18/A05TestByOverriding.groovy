package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 使用覆盖实现模拟 + 1
 *
 * @author moqi On 10/27/20 17:42
 */
class A05TestCodeWithHeavierDependenciesUsingOverriding extends GroovyTestCase {
    void testMyMethod() {
        def testObj = new CodeWithHeavierDependenciesExt()

        testObj.myMethod()

        assertEquals(35, testObj.result)
    }
}

class CodeWithHeavierDependenciesExt extends CodeWithHeavierDependencies {
    def result

    int someAction() { 25 }

    def println(text) {
        result = text
    }
}