package com.moqi.ch08

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

/**
 * 解析 XML
 *
 * @author moqi On 10/22/20 11:08
 */
document = DOMBuilder.parse(new FileReader('languages.xml'))

rootELement = document.documentElement

use(DOMCategory) {
    println("Languages ans authors")
    languages = rootELement.language

    languages.each {language ->
        println("${language.'@name'} authored by ${language.author[0].text()}")
    }

    def languagesByAuthor = {authorName ->
        languages.findAll { it.author[0].text() == authorName}.collect {
            it.'@name'
        }.join(', ')
    }

    println()

    println("Languages by wirth" + languagesByAuthor("Wirth"))
}
