package com.moqi.ch06

/**
 * 迭代 List
 *
 * @author moqi On 10/6/20 11:20
 */
lst = [1, 3, 4, 1, 8, 9, 2, 6]
lst.each { print("${it}, ") }
println()

lst.reverseEach { print("${it}, ") }
println()

lst.eachWithIndex { int entry, int i -> println("index: ${i}, value: ${entry}") }
println()

total = 0
lst.each { total += it }
println "total = $total"
println()

doubled = []
lst.each { doubled << it * 2 }
println(doubled)
println()

println lst.collect { it * 2 }
println()
