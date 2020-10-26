package com.moqi.ch14

/**
 * 为具体的实例合成方法
 *
 * @author moqi* On 10/26/20 11:03
 */
class A06Person {}

def emc = new ExpandoMetaClass(A06Person)
emc.methodMissing = {String name, args ->
    "I'm Jack of all trades... I can $name"
}
emc.initialize()

def jack = new A06Person()
def paul = new A06Person()

jack.metaClass = emc

println(jack.sing())
println(jack.dance())
println(jack.juggle())

try {
    paul.sing()
} catch (ex) {
    println(ex)
}
