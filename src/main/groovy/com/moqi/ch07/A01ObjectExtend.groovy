package com.moqi.ch07

/**
 * Object 类的扩展
 *
 * @author moqi On 10/21/20 14:33
 */
str = 'hello'

println(str)
println(str.dump())
println()

lst = [1, 2]
lst.add(3)
lst.add(4)
println(lst.size())
println(lst.contains(2))
println()

lst1 = [1, 2]
lst1.with {
    add(3)
    add(4)
    println(size())
    println(contains(2))
}
println()

lst1.with {
    println("this is ${this}")
    println("owner is ${owner}")
    println("delegate is ${delegate}")
}
println()






