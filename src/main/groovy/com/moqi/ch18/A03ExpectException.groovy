package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 测试异常
 *
 * @author moqi On 10/27/20 17:32
 */
class A03ExpectException extends GroovyTestCase {
    static def divide(int a, int b) {
        return a / b
    }

    void testDivide() {
        try {
            divide(2, 0)
            fail "Expected ArithmeticException ..."
        } catch (ArithmeticException ex) {
            assertTrue true
        }
    }

    // 在 Groovy 3.0.6 中无法使用
    // shouldFail ArithmeticException, {divide(2, 0)}
}