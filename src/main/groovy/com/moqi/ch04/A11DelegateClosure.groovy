package com.moqi.ch04

/**
 * 闭包委托
 *
 * @author moqi* On 10/5/20 09:00
 */
def examiningClosure(closure) {
    closure()
}

examiningClosure() {
    println("In First Closure: ")
    println("Class is " + getClass().name)
    println("this is " + this + ", super is " + this.getClass().superclass.name)
    println("owner is " + owner + ", super is " + owner.getClass().superclass.name)
    println("delegate is " + delegate + ", super is " + delegate.getClass().superclass.name)
    println()

    examiningClosure() {
        println("In Closure within the First Closure: ")
        println("Class is " + getClass().name)
        println("this is " + this + ", super is " + this.getClass().superclass.name)
        println("owner is " + owner + ", super is " + owner.getClass().superclass.name)
        println("delegate is " + delegate + ", super is " + delegate.getClass().superclass.name)
    }
    println()
}


class A11Handler {
    def f1() { println("f1 of Handler called ...") }

    def f2() { println("f2 of Handler called ...") }
}

class A11Example {
    def f1() { println("f1 of Example called ...") }

    def f2() { println("f2 of Example called ...") }

    def foo(closure) {
        closure.delegate = new A11Handler()
        closure()
    }
}

def f1() { println("f1 of Script called ...") }

new A11Example().foo {
    f1()
    f2()
}
