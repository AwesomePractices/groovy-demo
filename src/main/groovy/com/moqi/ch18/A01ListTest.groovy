package com.moqi.ch18

import groovy.test.GroovyTestCase

/**
 * 简单测试
 *
 * @author moqi On 10/27/20 15:11
 */
class A01ListTest extends GroovyTestCase {

    void testListSize() {
        def lst = [1, 2]
        assertEquals("ArrayList size must be 2", 2, lst.size())
    }

}
