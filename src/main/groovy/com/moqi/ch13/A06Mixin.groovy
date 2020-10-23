package com.moqi.ch13

/**
 * Mixin 测试
 *
 * 书中的注解 Mixin 已经被标记为过时了，用 trait 实现一些相关的功能
 *
 * https://stackoverflow.com/a/23124968
 * https://stackoverflow.com/a/36567736
 *
 * @author moqi* On 10/23/20 17:30
 */
trait A06Friend {
    def listen() {
        "$name is listening as a friend"
    }
}

class A06Person implements A06Friend {
    String firstName
    String lastName
    String getName() {
        "$firstName $lastName"
    }
}

john = new A06Person(firstName: 'John', lastName: 'Smith')
println(john.listen())
println()

class A06Dog implements A06Friend {
    String name
}

buddy = new A06Dog(name: 'Buddy')
println(buddy.listen())
println()

class A06Cat {
    String name
}

try {
    rude = new A06Cat(name: "Rude")
    rude.listen()
} catch (ex) {
    println(ex.message)
}
println()

class A06FriendClass implements A06Friend {}

mimi = new A06Cat(name: "Mimi")
mimi.metaClass.mixin(A06FriendClass)
println(mimi.listen())

