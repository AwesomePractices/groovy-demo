package com.moqi.ch06

/**
 * 使用 Map 类
 *
 * @author moqi On 10/6/20 11:51
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'MrCarthy']
println(langs.getClass().name)
println()

println(langs['Java'])
println(langs['C++'])
println(langs.Lisp)
println(langs.'C++')
println()

// 规则的键名可以省略引号
langs = ['C++': 'Stroustrup', Java: 'Gosling', Lisp: 'MrCarthy']
println(langs)
