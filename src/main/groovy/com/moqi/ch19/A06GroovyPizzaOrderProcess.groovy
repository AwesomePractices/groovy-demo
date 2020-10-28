package com.moqi.ch19

/**
 * Groovy Pizza Order Process
 *
 * @author moqi On 10/28/20 10:11
 */

final String DSL_PATH = '/Users/moqi/Code/groovy-demo/src/main/resources/orderPizza.dsl'
def dslDef = new File('A05GroovyPizzaDSL.groovy').text
def dsl = new File(DSL_PATH).text

def script = """
${dslDef}
acceptOrder {
    ${dsl}
}
"""

new GroovyShell().evaluate(script)
