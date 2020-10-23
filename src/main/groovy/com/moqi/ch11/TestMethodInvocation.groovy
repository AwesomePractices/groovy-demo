package com.moqi.ch11

import groovy.test.GroovyTestCase

/**
 * 确定 Groovy 在每种情况下会执行那个方法
 *
 * @author moqi* On 10/23/20 11:58
 */
class TestMethodInvocation extends GroovyTestCase {
    void testInterceptedMethodCallOnPOJO() {
        def val = new Integer(3)
        Integer.metaClass.toString = {-> 'intercepted'}

        assertEquals('intercepted', val.toString())
    }
}

