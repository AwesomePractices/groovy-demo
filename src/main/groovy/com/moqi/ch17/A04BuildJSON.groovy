package com.moqi.ch17

import groovy.json.JsonBuilder

/**
 * 构建 JSON
 *
 * @author moqi On 10/27/20 14:14
 */
class A04Person {
    String first
    String last
    def sigs
    def tools
}

john = new A04Person(first: "John", last: "Smith",
        sigs: ['Java', 'Groovy'], tools: ['script': 'Groovy', 'test': 'Spock'])
bldr = new JsonBuilder(john)
writer = new StringWriter()
bldr.writeTo(writer)
println writer


bldr = new JsonBuilder()
bldr {
    firstName john.first
    lastName john.last
    "special interest groups" john.sigs
    "preferred tools" {
        numberOfTools john.tools.size()
        tools john.tools
    }
}

writer = new StringWriter()
bldr.writeTo(writer)
println writer
