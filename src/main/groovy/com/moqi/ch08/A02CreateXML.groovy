package com.moqi.ch08

import groovy.xml.StreamingMarkupBuilder

/**
 * 创建 XML
 *
 * @author moqi On 10/22/20 11:35
 */
langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

content = ''
langs.each { language, author ->
  fragment = """
    <language name="${language}">
      <author>${author}</author>
    </language>
"""

  content += fragment
}
xml = "languages>${content}</languages>"
println xml

println()

xmlDocument = new StreamingMarkupBuilder().bind {
  mkp.xmlDeclaration()
  mkp.declareNamespace(computer: "Computer")
  languages {
    comment << "Created using StreamingMarkupBuilder"
    langs.each { key, value ->
      computer.language(name: key) {
	author (value)
      }
    }
  }
}
println xmlDocument


