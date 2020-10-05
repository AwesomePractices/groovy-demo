package com.moqi

/**
 * 对 Java 5 的支持
 * 变长参数、注解、静态导入、范型
 *
 * @author moqi On 9/26/20 21:30
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

import groovy.transform.*

// 逗号隔开字段的 toString
@Canonical
class A15Person {
    String firstName;
    String lastName;
    int age
}

person = new A15Person(firstName: 'Sara', lastName: 'walker', age: 49)
println "person = $person"
println()

class A15Worker {
    def work() { println('get work done') }

    def analyze() { println('work analyze') }

    def writeReport() { println('get work report') }
}

class A15Expert {
    def analyze() { println('expert analysis...') }
}

// 委托方法
class A15Manager {
    @Delegate
    A15Expert expert = new A15Expert()
    @Delegate
    A15Worker worker = new A15Worker()
}

manager = new A15Manager()
manager.analyze()
manager.work()
manager.writeReport()
println()

// 不可变类
@Immutable
class A15CreditCard {
    String cardNumber
    int creditLimit
}

card = new A15CreditCard('4000-1111-2222-3333', 1000000)
println "metaClass = $metaClass"
try {
    card.creditLimit = 10
} catch (ReadOnlyPropertyException ex) {
    println(ex.message)
}
println()

// 懒加载
class A15Heavy {
    def size = 10

    A15Heavy() { println("Creating Heavy with $size") }
}

class A15Needed {
    def value

    // Groovy 不仅推迟了创建，还将字段标记为 volatile，并确保创建期间是线程安全的
    @Lazy
    A15Heavy h1 = new A15Heavy()
    @Lazy
    A15Heavy h2 = new A15Heavy(size: value)

    A15Needed() { println('Created AsNeeded') }
}

asNeeded = new A15Needed(value: 1000)
println(asNeeded.h1.size)
println(asNeeded.h1.size)
println(asNeeded.h2.size)
println()

// 使用点 new 构造对象
@Newify([A15Person, A15CreditCard])
def fluentCreate() {
    println(A15Person.new(firstName: 'John', lastName: 'Doe', age: 20))
    println(A15Person(firstName: 'John', lastName: 'Doe', age: 20))
    println(A15CreditCard('123-123-123-123', 1000))
}

fluentCreate()
println()

// 单例模式
@Singleton(lazy = true, strict = false)
class A15TheUnique {
    private A15TheUnique() { println('Instance created') }

    def hello() { println('Hello World') }
}

A15TheUnique.instance.hello()
A15TheUnique.instance.hello()
