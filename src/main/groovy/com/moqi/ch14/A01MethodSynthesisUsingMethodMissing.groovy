package com.moqi.ch14

/**
 * 使用 methodMissing 合成方法
 *
 * @author moqi* On 10/26/20 10:21
 */
class A01Person {
    def work() { 'working' }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        println ("Method missing called for $name")
        def methodInList = plays.find {it == name.split('play')[1]}

        if (methodInList) {
            "playing ${name.split('play')[1]}"
        } else {
            throw new MissingMethodException(name, A01Person.class, args)
        }
    }
}

jack = new A01Person()

println(jack.work())
println(jack.playTennis())
println(jack.playBasketBall())
println(jack.playVolleyBall())
println(jack.playTennis())

try {
    jack.playPolitics()
} catch (Exception ex) {
    println(ex.message)
}
