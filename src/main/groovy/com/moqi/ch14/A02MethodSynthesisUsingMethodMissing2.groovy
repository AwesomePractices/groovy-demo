package com.moqi.ch14

/**
 * 使用 methodMissing 合成方法，并进行缓存
 *
 * @author moqi* On 10/26/20 10:21
 */
class A02Person {
    def work() { 'working' }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        println ("Method missing called for $name")
        def methodInList = plays.find {it == name.split('play')[1]}

        if (methodInList) {

            def impl = {Object[] vargs ->
                "playing ${name.split('play')[1]}"
            }

            A02Person instance = this
            instance.metaClass."$name" = impl // 以后再调用就会使用它
            impl(args)

        } else {
            throw new MissingMethodException(name, A02Person.class, args)
        }
    }
}

jack = new A02Person()

println(jack.playTennis())
println(jack.playTennis())

