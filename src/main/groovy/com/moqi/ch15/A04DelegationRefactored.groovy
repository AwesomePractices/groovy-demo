package com.moqi.ch15

/**
 * 重构委托调用
 *
 * @author moqi On 10/26/20 11:30
 */
class A04Worker {
    def simpleWork1(spec) {println("worker does work1 with spec $spec")}
    def simpleWork2() {println("worker does work2")}
}

class A04Expert {
    def advancedWork1(spec) {println("Expect does work1 with spec $spec")}
    def advancedWork2(scope, spec) {
        println("Expect does work2 with scope $scope spec $spec")
    }
}

class A04Manager {
    {delegateCallsTo A04Worker, A04Expert, GregorianCalendar}

    def schedule() {println("Scheduling ...")}
}

Object.metaClass.delegateCallsTo = {Class... classOfDelegates ->
    def objectOfDelegates = classOfDelegates.collect {it.newInstance()}

    delegate.metaClass.methodMissing = {String name, args ->
        println("intercepting call to $name...")

        def delegateTo = objectOfDelegates.find {
            it.metaClass.respondsTo(it, name, args)
        }

        if (delegateTo) {
            delegate.metaClass."$name" = {Object[] varArgs ->
                delegateTo.invokeMethod(name, varArgs)
            }

            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, delegate.getClass(), args)
        }
    }
}

peter = new A04Manager()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork1('quality')
peter.simpleWork2()
peter.simpleWork2()
peter.advancedWork1('fast')
peter.advancedWork1('quality')
peter.advancedWork2('prototype', 'fast')
peter.advancedWork2('product', 'quality')

// 方法来自于类 GregorianCalendar 中
println("Is 2008 a leap year? " + peter.isLeapYear(2008))

try {
    peter.simpleWork3()
} catch (ex) {
    println(ex)
}
