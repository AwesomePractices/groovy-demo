package com.moqi.ch06

/**
 * Map 上的其他便捷方法
 *
 * @author moqi On 10/8/20 10:23
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'MrCarthy']

print("Does any language name have a non alphabetic character: ")
println(langs.any { language, author ->
    language =~ "[^A-Za-z]"
})
println()

print("Does all language name have a non alphabetic character: ")
println(langs.every { language, author ->
    language =~ "[^A-Za-z]"
})
println()


friends = [briang : 'Brian Goetz', brians: 'Brain Sletten',
           davidb : 'David Bock', davidg: 'David Geary',
           scottd : 'Scott Davis', scottl: 'Scott Leberknight',
           stuarth: 'Stuart  Halloway']

groupByFirstName = friends.groupBy { it.value.split(' ')[0] }

groupByFirstName.each { firstName, buddies ->
    println("$firstName: ${buddies.collect { key, fullName -> fullName }.join(', ')}")
}
