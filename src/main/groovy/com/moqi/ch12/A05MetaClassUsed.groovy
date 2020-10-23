package com.moqi.ch12

import groovy.transform.Immutable

/**
 * ExpandoMetaClass 行为测试
 *
 * @author moqi* On 10/23/20 16:06
 */
def printMetaClassInfo(instance) {
    print "MetaClass of ${instance} is ${instance.metaClass.class.simpleName}"
    println " with delegate ${instance.metaClass.delegate.class.simpleName}"
}

printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"
println "Adding a method to Integer metaClass"
Integer.metaClass.someNewMethod = { -> /* */ }
printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"

@Immutable
class MyClass {
    String name
}

obj1 = new MyClass("obj1")

printMetaClassInfo(obj1)
println "Adding a method to myClass metaClass"
MyClass.metaClass.someNewMethod = { -> /* */ }
printMetaClassInfo(obj1)

println "obj2 created later"
obj2 = new MyClass("obj2")
printMetaClassInfo(obj2)
