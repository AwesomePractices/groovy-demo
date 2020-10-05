package com.moqi.ch04

/**
 * 动态闭包
 *
 * @author moqi On 10/5/20 08:48
 */
def doSomeThing(closure) {
    if (closure) {
        closure()
    } else {
        println("Using default implementation.")
    }
}

doSomeThing() { println("Use specialized implementation.") }
doSomeThing()
println()

def completeOrder(amount, taxComputer) {
    tax = 0

    if (taxComputer.maximumNumberOfParameters == 2) { // 期望传入税率
        tax = taxComputer(amount, 6.05)
    } else { // 使用默认税率
        tax = taxComputer(amount)
    }

    println("Sales tax is ${tax}")
}

completeOrder(100) { it * 0.0825 }
completeOrder(100) { amount, rate -> amount * (rate / 100) }
println()

def examine(closure) {
    println("${closure.maximumNumberOfParameters} parameter(s) given: ")
    for (aParameter in closure.parameterTypes) {
        println(aParameter.name)
    }
    println('--')
}

examine() {}
examine() { it }
examine() { -> }
examine() { val1 -> }
examine() { Date val1 -> }
examine() { Date val1, val2 -> }
examine() { Date val1, String val2 -> }



