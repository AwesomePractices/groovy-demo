package com.moqi.ch12

/**
 * 使用 GroovyInterceptable 拦截方法
 *
 * @author moqi* On 10/23/20 15:01
 */
class A01Car implements GroovyInterceptable {
    def check() { System.out.println("check called...") }

    def start() { System.out.println("start called...") }

    def drive() { System.out.println("drive called...") }

    def invokeMethod(String name, args) {
        System.out.println("")
        System.out.print("Call to $name intercepted... ")

        if (name != 'check') {
            System.out.print("running filter...")
            A01Car.metaClass.getMetaMethod('check').invoke(this, null)
        }

        def validMethod = A01Car.metaClass.getMetaMethod(name, args)
        if (validMethod != null) {
            validMethod.invoke(this, args)
        } else {
            A01Car.metaClass.invokeMethod(this, name, args)
        }
        System.out.println("")
    }
}

A01Car car = new A01Car()

car.start()
car.drive()
car.check()

try {
    car.speed()
} catch (Exception e) {
    println(e)
}