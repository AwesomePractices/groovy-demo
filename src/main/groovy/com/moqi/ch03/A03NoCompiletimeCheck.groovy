package com.moqi.ch03

import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

/**
 * 静态类型检查
 *
 * @author moqi* On 9/27/20 22:14
 */
def shout(String str) {
    println('Printing in uppercase')
    println(str.toUpperCase())
    println('Printing again in uppercase')
    // 一个故意的拼写错误
    println(str.toUppercase())
}

try {
    shout('Hello')
} catch (ex) {
    println('Failed...')
}
println()

@TypeChecked
def shoutCheck(String str) {
    println('Printing in uppercase')
    println(str.toUpperCase())
    println('Printing again in uppercase')
    // 一个故意的拼写错误，带上 TypeChecked 注解后这里直接编译失败
    // println(str.toUppercase())
}


def shoutString(String str) {
    println(str.shout())
}

str = 'hello'
// 元编程将 shout 映射到 toUpperCase
str.metaClass.shout = {-> toUpperCase()}
shoutString(str)
println()

@TypeChecked
def shoutStringCheck(String str) {
    // 带上 TypeChecked 注解则无法使用元编程
    // println(str.shout())
}


@TypeChecked
def printInReverse(String str) {
    println(str.reverse())
}

printInReverse('Hello')
println()

@TypeChecked
def use(Object instance) {
    if (instance instanceof String) {
        // 无需进行强制转换
        println(instance.length())
    } else {
        println(instance)
    }
}

use('Hello')
use(22222)
println()


@TypeChecked
class A03Simple {
    def method() {}

    // SKIP 跳过检查
    @TypeChecked(TypeCheckingMode.SKIP)
    def method2(String str) {
        str.shout()
    }
}
