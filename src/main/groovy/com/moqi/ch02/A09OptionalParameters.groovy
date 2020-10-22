package com.moqi.ch02

/**
 * 可选形参
 *
 * @author moqi On 9/26/20 20:58
 */
static def log(x, base=10) {
    Math.log(x) / Math.log(base)
}

println(log(1024))
println(log(1024, 10))
println(log(2014, 2))

static def task(name, String[] details) {
    println("$name - $details")
}

task 'Call', '123-456-7890'
task 'Call', '123-456-7890', '231-546-0987'
task 'Check Mail'
