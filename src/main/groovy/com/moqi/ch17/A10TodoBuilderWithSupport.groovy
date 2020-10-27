package com.moqi.ch17

/**
 * A10 TodoBuilderWithSupport
 *
 * @author moqi On 10/27/20 14:37
 */
class A10TodoBuilderWithSupport extends BuilderSupport {
    int level = 0
    def result = new StringWriter()

    void setParent(parent, child) {}

    def createNode(name) {
        if (name == 'build') {
            result << "To-Do:\n"
            'build_node'
        } else {
            handle(name, [:])
        }
    }

    def createNode(name, Object value) {
        throw new Exception("Invalid format")
    }

    def createNode(name, Map attribute) {
        handle(name, attribute)
    }

    def createNode(name, Map attribute, Object value) {
        throw new Exception("Invalid format")
    }

    def propertyMissing(String name) {
        handle(name, [:])
        level--
    }

    void nodeCompleted(parent, node) {
        level--
        if (node == 'build_node') {
            println result
        }
    }

    def handle(String name, attributes) {
        level++
        level.times { result << " " }
        result << placeXifStatusDone(attributes)
        result << name.replaceAll("_", " ")
        result << printParameters(attributes)
        result << "\n"
        name
    }

    static def placeXifStatusDone(attributes) {
        attributes['status'] == 'done' ? "X " : "- "
    }

    static def printParameters(attributes) {
        def values = ""
        if (attributes.size() > 0) {
            values += " ["
            def count = 0
            attributes.each { key, value ->
                if (key == 'status') return
                count++
                values += (count > 1 ? " " : "")
                values += "${key}: ${value}"
            }
            values += "]"
        }
        values
    }
}