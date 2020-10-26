package com.moqi.ch14

/**
 * 使用 ExpandoMetaClass 合成方法
 *
 * @author moqi* On 10/26/20 10:46
 */
class A05Person {
    def work() { "working" }
}

A05Person.metaClass.invokeMethod = {String name, args ->
    System.out.println("intercepting call for $name")
    
    def method = A05Person.metaClass.getMetaMethod(name, args)
    
    if (method) {
        method.invoke(delegate, args)
    } else {
        A05Person.metaClass.invokeMissingMethod(delegate, name, args)
    }
}

A05Person.metaClass.methodMissing = { String name, args ->
    def plays = ['Tennis', 'Basketball', 'VolleyBall']

    System.out.println("methodMissing called for $name")
    def methodInList = plays.find { it == name.split('play')[1] }

    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}"
        }

        A05Person.metaClass."$name" = impl
        impl(args)
    } else {
        throw new MissingMethodException(name, A05Person.class, args)
    }
}

jack = new A05Person()
println(jack.work())
println(jack.playTennis())
println(jack.playTennis())
