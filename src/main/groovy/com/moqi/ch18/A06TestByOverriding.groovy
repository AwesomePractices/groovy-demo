package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 使用覆盖实现模拟 Java + 1
 *
 * @author moqi On 10/27/20 17:42
 */
class A06TestCodeWithHeavierDependenciesUsingOverriding extends GroovyTestCase {
    void testMyMethod() {
        def testObj = new ExtendedJavaCode()

        def originalPrintStream = System.out
        def printMock = new PrintMock()
        System.out = printMock

        try {
            testObj.myMethod()
        } finally {
            System.out = originalPrintStream
        }

        assertEquals(35, printMock.result)
    }
}

class ExtendedJavaCode extends A02JavaCodeWithHeavierDependencies {
    int someAction() { 25 }
}

class PrintMock extends PrintStream {
    PrintMock() {
        super(System.out)
    }

    def result

    void println(int text) {
        result = text
    }
}