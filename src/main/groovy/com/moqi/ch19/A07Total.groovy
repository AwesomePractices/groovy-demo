package com.moqi.ch19

/**
 * 括号的限制与变通方案
 *
 * @author moqi On 10/28/20 10:15
 */
value = 0

def clear() {
    value = 0
}

def add(number) {
    value += number
}

def total() {
    println "Total is $value"
}

clear()
add 2
add 5
add 7
total()
println()

try {
    total
} catch (ex) {
    println(ex)
}

value = 0

def getClear() {
    value = 0
}

def getTotal() {
    println "Total is $value"
}

clear
add 2
add 2
add 2
add 2
add 2
add 2
add 2
add 2
add 2
add 2
add 2
add 2
add 2
total
clear
total