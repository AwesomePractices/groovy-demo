package com.moqi.ch15

/**
 * 方法委托：汇总练习
 *
 * @author moqi On 10/26/20 11:30
 */
class A02Worker {
    def simpleWork1(spec) {println("worker does work1 with spec $spec")}
    def simpleWork2() {println("worker does work2")}
}

class A02Expert {
    def advancedWork1(spec) {println("Expect does work1 with spec $spec")}
    def advancedWork2(scope, spec) {
        println("Expect does work2 with scope $scope spec $spec")
    }
}

class A02Manager {
    def worker = new A02Worker()
    def expert = new A02Expert()
    def schedule() {println("Scheduling ...")}

    def methodMissing (String name, args) {
        println("intercepting call to $name")

        def delegateTo = null

        if (name.startsWith('simple')) {
            delegateTo = worker
        }
        if (name.startsWith('advanced')) {
            delegateTo = expert
        }

        if (delegateTo?.metaClass?.respondsTo(delegateTo, name, args)) {
            A02Manager manager = this

            manager.metaClass."$name" = {Object[] varArgs ->
                delegateTo.invokeMethod(name, varArgs)
            }

            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, A02Manager.class, args)
        }
    }
}

peter = new A02Manager()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork1('quality')
peter.simpleWork2()
peter.simpleWork2()
peter.advancedWork1('fast')
peter.advancedWork1('quality')
peter.advancedWork2('prototype', 'fast')
peter.advancedWork2('product', 'quality')

try {
    peter.simpleWork3()
} catch (ex) {
    println(ex)
}
