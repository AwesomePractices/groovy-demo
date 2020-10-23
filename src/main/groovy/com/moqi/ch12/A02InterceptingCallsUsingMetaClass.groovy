package com.moqi.ch12

/**
 * 使用 MetaClass 拦截方法
 *
 * @author moqi* On 10/23/20 15:22
 */
class A02Car {
    def check() { System.out.println "check called..." }

    def start() { System.out.println "start called..." }

    def drive() { System.out.println "drive called..." }
}

A02Car.metaClass.invokeMethod = { String name, args ->
    System.out.println("")
    System.out.print("Call to $name intercepted... ")

    if (name != 'check') {
        System.out.print("running filter... ")
        A02Car.metaClass.getMetaMethod('check').invoke(delegate, null)
    }

    def validMethod = A02Car.metaClass.getMetaMethod(name, args)
    if (validMethod != null) {
        validMethod.invoke(delegate, args)
    } else {
        A02Car.metaClass.invokeMissingMethod(delegate, name, args)
    }
    System.out.println("")
}


car = new A02Car()

car.start()
car.drive()
car.check()

try {
    car.speed()
} catch (Exception ex) {
    println ex
}

