package com.moqi.ch03

/**
 * 元编程的鸭子对象模式
 *
 * @author moqi On 9/27/20 20:54
 */
class A01Man {
    void helpMoveThings() { println('Man\'s helping') }
}

class A01Woman {
    void helpMoveThings() { println('Woman\'s helping') }
}

class A01Elephant {
    void helpMoveThings() { println('Elephant\'s helping') }

    void eatSugarcane() { println('I love sugarcanes...') }
}

def takeHelp(helper) {
    helper.helpMoveThings()
}

takeHelp(new A01Man())
takeHelp(new A01Woman())
takeHelp(new A01Elephant())
println()

def takeHelpAndReword(helper) {
    helper.helpMoveThings()

    if (helper.metaClass.respondsTo(helper, 'eatSugarcane')) {
        helper.eatSugarcane()
    }
}

takeHelpAndReword(new A01Man())
takeHelpAndReword(new A01Woman())
takeHelpAndReword(new A01Elephant())
println()


