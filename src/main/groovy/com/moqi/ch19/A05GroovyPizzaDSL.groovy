package com.moqi.ch19

/**
 * 方法拦截与 DSL
 *
 * @author moqi On 10/28/20 10:08
 */
def large = 'large'
def thin = 'thin'
def visa = 'visa'
def Olives = 'Olives'
def Onions = 'Onions'
def Bell_Pepper = 'Bell Pepper'

orderInfo = [:]

def methodMissing(String name, args) {
    orderInfo[name] = args
}

def acceptOrder(closure) {
    closure.delegate = this
    closure()

    println("Validation and processing performed here for order received:")

    orderInfo.each {key, value ->
        println("${key} -> ${value.join(', ')}")
    }
}
