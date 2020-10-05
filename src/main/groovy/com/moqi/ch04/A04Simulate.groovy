package com.moqi.ch04

/**
 * 闭包在构造函数中的使用
 *
 * @author moqi On 10/3/20 14:52
 */
class A04Equipment {
    def calculator

    A04Equipment(calc) {calculator = calc}

    @SuppressWarnings('GroovyAssignabilityCheck')
    def simulate() {
        println("Running simulation")
        calculator() // 可能还会发送参数
    }
}

def eq1 = new A04Equipment({println(" Calculator 1")})
def aCalculator = {println(" Calculator 2")}
def eq2 = new A04Equipment(aCalculator)
def eq3 = new A04Equipment(aCalculator)

eq1.simulate()
eq2.simulate()
eq3.simulate()
