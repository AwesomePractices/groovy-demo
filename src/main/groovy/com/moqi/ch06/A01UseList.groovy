package com.moqi.ch06

/**
 * 使用 List
 *
 * @author moqi On 10/6/20 11:11
 */
lst = [1, 3, 4, 1, 8, 9, 2, 6]
println(lst)
println(lst.getClass().name)
println()

println(lst[0])
println(lst[lst.size() - 1])
println()

println(lst[-1])
println(lst[-2])
println()

println(lst[2..5])
println()

println(lst[-6..-3])
println()

subList = lst[2..5]
println(subList.dump())
println()

/*
 * WARNING: An illegal reflective access operation has occurred
 * WARNING: Illegal reflective access by org.codehaus.groovy.vmplugin.v9.Java9 (file:/Users/moqi/Applications/maven/repository/org/codehaus/groovy/groovy/3.0.4/groovy-3.0.4.jar) to field java.util.ArrayList.elementData
 * WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.vmplugin.v9.Java9
 * WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
 * WARNING: All illegal access operations will be denied in a future release
 * subList = [55, 1, 8, 9]
 * lst = [1, 3, 4, 1, 8, 9, 2, 6]
 */
subList[0] = 55
println "subList = $subList"
println "lst = $lst"
