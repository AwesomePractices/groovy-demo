package com.moqi.ch11

/**
 * 查询方法与属性
 *
 * @author moqi* On 10/23/20 14:45
 */
str = 'hello'
// 名字可能来自于输入，而不是硬编码
methodName = 'toUpperCase'

methodOfInterest = str.metaClass.getMetaMethod(methodName)
println(methodOfInterest.invoke(str))
println()

print("Does String respond to toUpperCase()? ")
println(String.metaClass.respondsTo(str, 'toUpperCase') ? 'yes' : 'no')

print("Does String respond to compareTo(String)? ")
println(String.metaClass.respondsTo(str, 'compareTo', 'test') ? 'yes' : 'no')

print("Does String respond to toUpperCase(int)? ")
println(String.metaClass.respondsTo(str, 'toUpperCase', 5) ? 'yes' : 'no')
println()

