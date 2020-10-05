package com.moqi.ch04

/**
 * 闭包与协程
 *
 * @author moqi On 10/3/20 15:46
 */
def iterate(n, closure) {
    1.upto(n) {
        println("In iterate with value ${it}")
        closure(it)
    }
}

println("Calling iterate")
total = 0
iterate(4) {
    total += it
    println("In closure total so far is ${total}")
}
println("Done")

