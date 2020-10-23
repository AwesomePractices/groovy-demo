package com.moqi.ch13

/**
 * 在类中使用多个 Mixin
 *
 * @author moqi* On 10/23/20 19:20
 */
abstract class A08Writer {
    abstract void write(String message)
}

class A08StringWriter extends A08Writer {
    def target = new StringBuilder()

    @Override
    void write(String message) {
        target.append(message)
    }

    String toString() {
        target.toString()
    }
}

def writeStuff(writer) {
    writer.write("This is stupid")
    println(writer)
}

def create(theWriter, Object[] filters = []) {
    def instance = theWriter.newInstance()
    filters.each { filter -> instance.metaClass.mixin(filter) }
    instance
}

writeStuff(create(A08StringWriter))

println()

class A08UpperCaseFilter {
    void write(String message) {
        def allUpper = message.toUpperCase()

        invokeOnPreviousMixin(metaClass, "write", allUpper)
    }
}

Object.metaClass.invokeOnPreviousMixin = {
    MetaClass currentMixinMetaClass, String method, Object[] args ->
        def previousMixin = delegate.getClass()

        for (mixin in mixedIn.mixinClasses) {
            if (mixin.mixinClass.theClass == currentMixinMetaClass.delegate.theClass) {
                break
            }

            previousMixin = mixin.mixinClass.theClass
        }

        mixedIn[previousMixin]."$method"(*args)
}

writeStuff(create(A08StringWriter, A08UpperCaseFilter))

println()

class A08ProfanityFilter {
    void write(String message) {
        def filtered = message.replaceAll('stupid', 's*****')
        invokeOnPreviousMixin(metaClass, 'write', filtered)
    }
}

writeStuff(create(A08StringWriter, A08ProfanityFilter))

writeStuff(create(A08StringWriter, A08UpperCaseFilter, A08ProfanityFilter))
writeStuff(create(A08StringWriter, A08ProfanityFilter, A08UpperCaseFilter))
