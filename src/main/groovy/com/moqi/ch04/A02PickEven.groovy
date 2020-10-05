package com.moqi.ch04

/**
 * 使用闭包抽取函数的公共部分
 *
 * @author moqi On 10/3/20 14:38
 */
static def pickEven(n, block) {
    for (int i = 2; i <= n; i += 2) {
        block(i)
    }

    println()
}

pickEven(10, {println it})
pickEven(10) {println it}
pickEven(10) {evenNumber -> println evenNumber}

total = 0
pickEven(10) {total += it}
println("Sum of even numbers from 1 to 10 is $total")

product = 1
pickEven(10) {product *= it}
println("Product of even numbers from 1 to 10 is $product")
