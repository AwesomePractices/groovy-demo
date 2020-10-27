package com.moqi.ch17

import groovy.xml.StreamingMarkupBuilder

/**
 * 构建 XML 大文件
 *
 * @author moqi On 10/27/20 14:11
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

xmlDocument = new StreamingMarkupBuilder().bind {
    mkp.xmlDeclaration()
    mkp.declareNamespace(computer: "Computer")
    languages {
        comment << "Created using StreamingMarkupBuilder"
        langs.each { key, value ->
            computer.language(name: key) {
                author(value)
            }
        }
    }
}
println xmlDocument