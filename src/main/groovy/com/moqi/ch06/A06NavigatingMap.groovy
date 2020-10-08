package com.moqi.ch06

/**
 * 在 Map 上迭代
 *
 * @author moqi On 10/8/20 10:14
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'MrCarthy']

langs.each { entry ->
    println("Language $entry.key was authored by $entry.value")
}
println()

langs.each {language, author ->
    println("Language $language was authored by $author")
}
println()

println(langs.collect {language, author ->
    language.replaceAll("[+]", "P")
})
println()

println("Looking for the first language with name greater than 3 characters")
entry = langs.find {language, author ->
    language.size() > 3
}
println("Found $entry.key written by $entry.value")
println()

println("Looking for all languages with name greater than 3 characters")
selected = langs.findAll {language, author ->
    language.size() > 3
}
selected.each {k, v ->
    println("Found $k written by $v")
}
println()




