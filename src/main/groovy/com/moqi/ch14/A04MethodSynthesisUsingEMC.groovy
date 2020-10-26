package com.moqi.ch14

/**
 * 使用 ExpandoMetaClass 合成方法
 *
 * @author moqi* On 10/26/20 10:46
 */
class A04Person {
    def work() { "working" }
}

A04Person.metaClass.methodMissing = { String name, args ->
    def plays = ['Tennis', 'Basketball', 'VolleyBall']

    System.out.println("methodMissing called for $name")
    def methodInList = plays.find { it == name.split('play')[1] }

    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}"
        }

        A04Person.metaClass."$name" = impl
        impl(args)
    } else {
        throw new MissingMethodException(name, A04Person.class, args)
    }
}

jack = new A04Person()
println(jack.work())
println(jack.playTennis())
println(jack.playTennis())

try {
    jack.playPiano()
} catch (ex) {
    println(ex)
}