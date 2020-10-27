package com.moqi.ch17

/**
 * TodoBuilder
 *
 * @author moqi On 10/27/20 14:34
 */
class A08TodoBuilder {
    def level = 0
    def result = new StringWriter()

    def build(closure) {
        result << "To-Do:\n"
        closure.delegate = this
        closure()
        println result
    }

    def methodMissing(String name, args) {
        handle(name, args)
    }

    def propertyMissing(String name) {
        Object[] emptyArray = []
        handle(name, emptyArray)
    }

    def handle(String name, args) {
        level++
        level.times { result << " " }
        result << placeXifStatusDone(args)
        result << name.replaceAll("_", " ")
        result << printParameters(args)
        result << "\n"

        if (args.length > 0 && args[-1] instanceof Closure) {
            def theClosure = args[-1]
            theClosure.delegate = this
            theClosure()
        }

        level--
    }

    static def placeXifStatusDone(args) {
        args.length > 0 && args[0] instanceof Map &&
                args[0]['status'] == 'done' ? "x " : "- "
    }

    static def printParameters(args) {
        def values = ""
        if (args.length > 0 && args[0] instanceof Map) {
            values += " ["
            def count = 0
            args[0].each { key, value ->
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
