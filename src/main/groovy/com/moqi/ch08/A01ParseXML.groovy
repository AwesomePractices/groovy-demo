package com.moqi.ch08

import groovy.xml.DOMBuilder
import groovy.xml.XmlParser
import groovy.xml.XmlSlurper
import groovy.xml.dom.DOMCategory

/**
 * 解析 XML
 *
 * @author moqi On 10/22/20 11:08
 */
final String LANGUAGES_XML = "/Users/moqi/Code/groovy-demo/src/main/resources/languages.xml"

document = DOMBuilder.parse(new FileReader(LANGUAGES_XML))

rootELement = document.documentElement

use(DOMCategory) {
    println("Languages and authors")
    languages = rootELement.language

    languages.each { language ->
        println("${language.'@name'} authored by ${language.author[0].text()}")
    }

    def languagesByAuthor = { authorName ->
        languages.findAll { it.author[0].text() == authorName }.collect {
            it.'@name'
        }.join(', ')
    }

    println()
    println("Languages by wirth" + languagesByAuthor("Wirth"))
}


println()

languages1 = new XmlParser().parse(LANGUAGES_XML)
println("Languages and authors")

languages1.each {
    println("${it.@name} authored by ${it.author[0].text()}")
}

def languagesByAuthor1 = { authorName ->
    languages1.findAll { it.author[0].text() == authorName }.collect {
        it.@name
    }.join(', ')
}

println()
println("Languages by Wirth: " + languagesByAuthor1('Wirth'))

println()

languages2 = new XmlSlurper().parse(LANGUAGES_XML)
println("Languages and authors")

languages2.language.each {
    println("${it.@name} authored by ${it.author[0].text()}")
}

def languagesByAuthor2 = { authorName ->
    languages2.language.findAll { it.author[0].text() == authorName }.collect {
        it.@name
    }.join(', ')
}

println()
println("Languages by Wirth: " + languagesByAuthor2('Wirth'))

println()

final String COMPUTER_AND_NATURAL_LANGUAGES_XML = "/Users/moqi/Code/groovy-demo/src/main/resources/computerAndNaturalLanguages.xml"
languagesN = new XmlSlurper().parse(COMPUTER_AND_NATURAL_LANGUAGES_XML).declareNamespace(human: 'Natural')

print("Languages: ")
println(languagesN.language.collect { it.@name }.join(", "))

print("Natural languages: ")
println(languagesN.'human:language'.collect { it.@name }.join(", "))
