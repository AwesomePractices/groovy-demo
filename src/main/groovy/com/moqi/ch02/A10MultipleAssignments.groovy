package com.moqi.ch02

/**
 * 使用多赋值
 *
 * @author moqi On 9/26/20 21:02
 */
static def splitName(fullName) { fullName.split(' ') }

def (firstName, lastName) = splitName('James Bond')
println("$lastName, $firstName $lastName")

def name1 = 'tom'
def name2 = 'jack'

println("$name1 ans $name2")
(name1, name2) = [name2, name1]
println("$name1 ans $name2")

def (String cat, String mouse) = ['Tom', 'Jerry', 'Spike', 'Tyke']
println("$cat and $mouse")

def (first, second, third) = ['Tom', 'Jerry']
println("$first, $second, $third")
