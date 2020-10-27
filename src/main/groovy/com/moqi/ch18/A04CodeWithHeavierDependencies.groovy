package com.moqi.ch18

/**
 * 使用覆盖实现模拟
 *
 * @author moqi On 10/27/20 17:40
 */
class CodeWithHeavierDependencies {
    void myMethod() {
        def value = someAction() + 10
        println(value)
    }

    int someAction() {
        // 模拟消耗时间的动作
        Thread.sleep(5000)

        // 模拟某个动作的结果
        return Math.random() * 100
    }
}