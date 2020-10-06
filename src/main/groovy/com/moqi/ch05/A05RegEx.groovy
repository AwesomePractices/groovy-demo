package com.moqi.ch05

/**
 * 正则表达式
 *
 * @author moqi On 10/5/20 10:36
 */
obj1 = ~"hello"
// java.util.regex.Pattern
println(obj1.getClass().name)
println()


pattern = ~"([Gg])roovy"
text = 'Groovy is Hip'
// 部分匹配
if (text =~ pattern) {
    println('=~ match')
} else {
    println('=~ not match')
}

// 精确匹配
if (text ==~ pattern) {
    println('==~ match')
} else {
    println('==~ not match')
}
println()


matcher = 'Groovy is groovy' =~ /[Gg]roovy/
println("Size of matcher is ${matcher.size()}")
println("with elements ${matcher[0]} and ${matcher[1]}")
println()

str1 = 'Groovy is groovy, really groovy'
println(str1)
result = (str1 =~ /groovy/).replaceAll('hip')
println(result)


