package com.moqi.ch05

/**
 * 字面常量与表达式
 *
 * @author moqi* On 10/5/20 09:52
 */
println('He said, "That is Groovy"')
println()

str = 'A String'
println(str.getClass().name)
println()

value = 25
println('The value is ${value}')
println("The value is ${value}")
println()

hello = 'Hello'
println(hello)
try {
    hello[2] = '!'
} catch (Exception ex) {
    println(ex)
}
println()

value1 = 12
println("He paid \$${value1} for that.")
println()


what1 = new StringBuilder("fence")
text1 = "The cow jumped over the $what1"
println(text1)
what1.replace(0, 5, "moon")
println(text1)
println()

def printClassInfo(obj) {
    println("class: ${obj.getClass().name}")
    println("super class: ${obj.getClass().superclass.name}")
}

val2 = 125
printClassInfo("The Stock closed at ${val2}")
printClassInfo(/The Stock closed at ${val2}/)
printClassInfo("This is a simple String")
println()
