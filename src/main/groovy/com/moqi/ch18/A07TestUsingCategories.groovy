package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 使用分类实现模拟
 *
 * @author moqi On 10/27/20 17:53
 */
class A07TestUsingCategories extends GroovyTestCase {

    void testMyMethod() {
        def testObj = new CodeWithHeavierDependencies()

        use(MockHelper) {
            testObj.myMethod()

            assertEquals(35, MockHelper.result)
        }
    }

}

class MockHelper {
    def static result

    def static println(self, text) {
        result = text
    }

    def static someAction(CodeWithHeavierDependencies self) {
        25
    }
}