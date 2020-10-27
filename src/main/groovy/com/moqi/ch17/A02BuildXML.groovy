package com.moqi.ch17

import groovy.xml.MarkupBuilder

/**
 * 构建 XML
 *
 * @author moqi On 10/27/20 14:09
 */
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

writer = new StringWriter()
bldr = new MarkupBuilder(writer)
bldr.languages {
    langs.each { key, value ->
        language(name: key) {
            author(value)
        }
    }
}
println writer
