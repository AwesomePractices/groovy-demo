package com.moqi.ch03

import groovy.transform.CompileStatic

/**
 * 静态编译提高性能
 *
 * @author moqi On 9/27/20 22:26
 */
def shout1(String str) {
    println(str.toUpperCase())
}

@CompileStatic
def shout1Static(String str) {
    println(str.toUpperCase())
}

str = 'Hello'
shout1(str)
shout1Static(str)
