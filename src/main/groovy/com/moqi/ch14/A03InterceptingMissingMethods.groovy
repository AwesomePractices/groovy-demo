package com.moqi.ch14

/**
 * invokeMethod 拦截对现有方法和合成的方法的调用
 *
 * @author moqi* On 10/26/20 10:21
 */
class A03Person implements GroovyInterceptable {
    def work() { 'working' }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def invokeMethod(String name, args) {
        System.out.println("incercepting call for $name")

        def method = metaClass.getMetaMethod(name, args)

        if (method) {
            method.invoke(this, args)
        } else {
            metaClass.invokeMethod(this, name, args)
        }
    }

    def methodMissing(String name, args) {
        System.out.println("Method missing called for $name")
        def methodInList = plays.find { it == name.split('play')[1] }

        if (methodInList) {

            def impl = { Object[] vargs ->
                "playing ${name.split('play')[1]}"
            }

            A03Person instance = this
            instance.metaClass."$name" = impl // 以后再调用就会使用它
            impl(args)

        } else {
            throw new MissingMethodException(name, A03Person.class, args)
        }
    }
}

jack = new A03Person()

println(jack.work())
println(jack.playTennis())
println(jack.playTennis())

