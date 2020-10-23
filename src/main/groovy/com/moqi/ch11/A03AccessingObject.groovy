package com.moqi.ch11

/**
 * 动态访问对象
 *
 * @author moqi* On 10/23/20 14:50
 */
def printInfo(obj) {
    // 假定用户从标准输入键入这些值
    usrRequestedProperty = 'bytes'
    usrRequestedMethod = 'toUpperCase'

    println(obj[usrRequestedProperty])
    // 或者
    println(obj."$usrRequestedProperty")

    println(obj."$usrRequestedMethod"())
    // 或者
    println(obj.invokeMethod(usrRequestedMethod, null))
}

printInfo('Hello')
println()

println('Properties of "hello" are: ')
'hello'.properties.each {println it}

