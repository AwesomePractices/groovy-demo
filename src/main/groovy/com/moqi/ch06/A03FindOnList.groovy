package com.moqi.ch06

/**
 * List 使用查找方法
 *
 * @author moqi On 10/6/20 11:29
 */
lst = [4, 3, 1, 2, 4, 1, 8, 9, 2, 6]
println(lst.find { it == 2 })
println()

println(lst.find {it > 4})
println()

println(lst.findAll {it == 2})
println()

println(lst.findAll {it > 4})
