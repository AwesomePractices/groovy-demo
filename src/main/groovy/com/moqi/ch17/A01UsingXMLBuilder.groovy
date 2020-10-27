package com.moqi.ch17

import groovy.xml.MarkupBuilder

/**
 * 构建 XML
 *
 * @author moqi On 10/27/20 11:57
 */
bldr = new MarkupBuilder()

bldr.languages {
    language(name: 'C++') { author('Stroustrup') }
    language(name: 'Java') { author('Gosling') }
    language(name: 'Lisp') { author('McCarthy') }
}
