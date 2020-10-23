package com.moqi.ch13

/**
 * 向具体的示例中注入方法
 *
 * @author moqi* On 10/23/20 17:24
 */
class A05Person {
    def play() { println("playing...") }
}

def emc = new ExpandoMetaClass(A05Person)
emc.sing = { ->
    'Oh baby baby'
}
emc.initialize()

def jack = new A05Person()
def paul = new A05Person()

jack.metaClass = emc
println(jack.sing())

try {
    paul.sing()
} catch (ex) {
    println(ex)
}

jack.metaClass = null

try {
    jack.play()
    jack.sing()
} catch (ex) {
    println(ex)
}