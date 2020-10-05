package com.moqi

import org.codehaus.groovy.runtime.typehandling.GroovyCastException

/**
 * 陷阱
 *
 * @author moqi On 9/26/20 22:40
 */
str1 = 'hello'
str2 = str1
str3 = new String('hello')
str4 = 'Hello'

println("str1 == str2: ${str1 == str2}")
println("str1 == str3: ${str1 == str3}")
println("str1 == str4: ${str1 == str4}")
println("str1.is(str2): ${str1.is(str2)}")
println("str1.is(str3): ${str1.is(str3)}")
println("str1.is(str4): ${str1.is(str4)}")
println()


class A16A {
    boolean equals(other) {
        println "A16A.equals"
        false
    }
}

class A16B implements Comparable {
    boolean equals(other) {
        println "A16B.equals"
        false
    }

    int compareTo(other) {
        println "A16B.compareTo"
        0
    }
}

println(new A16A() == new A16A())
println(new A16B() == new A16B())
println()


Integer val = 4

try {
    //noinspection GroovyAssignabilityCheck
    val = 'hello'
} catch (GroovyCastException ex) {
    println(ex.message)
}

try {
    val.hahaha()
} catch (MissingMethodException ex) {
    println(ex.message)
}

// 书中原文（别用这样的代码块，Groovy 会以为要定义闭包），经测试 Groovy 3.0.5 不会报错
static void method(int arg) {
    println("arg = " + arg);
    {
        println("arg = " + arg);
    }
}

method(10)
println()

// 闭包与匿名内部类冲突
class A16Calibrator {
    A16Calibrator(calculationBlock) {
        print "using..."
        calculationBlock()
    }
}

cal1 = new A16Calibrator({
    println "The calculation provided"
})
cal = { "another calculation provided" }
cal2 = new A16Calibrator(cal)
println()

// 分号总是可选的
@SuppressWarnings('GrUnnecessarySemicolon')
class A16Semi {
    // 这个分号不可以省略，否则 Groovy 会将此类实例化器看成一个闭包，最终报错
    def val = 3;

    {
        println('Instance Initializer called...')
    }
}

println(new A16Semi())
println()

// 创建基本类型数组
int[] arr1 = new int[]{1, 2, 3, 4, 5}
println "arr1 = $arr1"

int[] arr2 = [1, 2, 3, 4, 5]
println "arr2 = $arr2"
println(arr2.class.name)

// 默认指定数据类型为 ArrayList
arr3 = [1,2,3,4,5]
println(arr3.class.name)

arr4 = [1,2,3,4,5] as int[]
println(arr4.class.name)
