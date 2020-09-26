package com.moqi

/**
 * 对 Java 5 的支持
 * 变长参数、注解、静态导入、范型
 *
 * @author moqi* On 9/26/20 21:30
 */
def receiveCarArgs(int a, int ... b) {
    println "a = $a, b = $b"
}

def receiveArray(int a, int[] b) {
    println "a = $a, b = $b"
}

receiveCarArgs(1, 2, 3, 4, 5)
receiveArray(1, 2, 3, 4, 5)

int[] values = [2, 3, 4, 5]
receiveCarArgs(1, values)
receiveCarArgs(1, [2, 3, 4, 5] as int[])

try {
    // 需要显示声名类型
    //noinspection GroovyAssignabilityCheck
    receiveCarArgs(1, [2, 3, 4, 5])
} catch (MissingMethodException ex) {
    println(ex.message)
}
println()

// 导入可以带上别名
import static java.lang.Math.random as rand
import groovy.lang.ExpandoMetaClass as EMC

println(rand())
def metaClass = new EMC(Integer)
println(metaClass.getClass().name)
println()
