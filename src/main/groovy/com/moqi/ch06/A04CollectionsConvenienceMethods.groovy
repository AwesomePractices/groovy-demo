package com.moqi.ch06

/**
 * List 上的其他便捷方法
 *
 * @author moqi On 10/6/20 11:33
 */
lst = ['Programming', 'In', "Groovy"]
count = 0
lst.each { count += it.size() }
println "count = $count"
println()

println(lst.collect { it.size() }.sum())
println()

println(lst.inject(0) { carryOver, element -> carryOver + element.size() })
println()

println(lst.join(' '))
println()

lst[0] = ['Be', 'Productive']
println "lst = $lst"
println()

lst = lst.flatten()
println "lst = $lst"
println()

println(lst - ['Productive', 'In'])
println()

println(lst.size())
// lst*.size() 等于 lst.collect{ it.size() }
println(lst*.size())
println()

def words(a, b, c, d) {
    println("$a $b $c $d")
}
// Python 的解包
words(*lst)
