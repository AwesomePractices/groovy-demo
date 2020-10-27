package com.moqi.ch17

import groovy.json.JsonSlurper

/**
 * 解析 JSON
 *
 * @author moqi On 10/27/20 14:23
 */
final String JSON_PATH = '/Users/moqi/Code/groovy-demo/src/main/resources/person.json'

def slurper = new JsonSlurper()
def person = slurper.parse(new FileReader(JSON_PATH))

println "$person.first $person.last is interested in ${person.sigs.join(', ')}"
