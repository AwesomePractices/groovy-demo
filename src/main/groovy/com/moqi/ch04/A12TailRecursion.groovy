package com.moqi.ch04

/**
 * 使用尾递归编写程序
 *
 * @author moqi* On 10/5/20 09:16
 */
def factorial(BigInteger number) {
    if (number == 1) 1 else number * factorial(number - 1)
}

// factorial of 5 is 120
// Caught java.lang.StackOverflowError
try {
    println("factorial of 5 is ${factorial(5)}")
    println("Number of bits in the result is ${factorial(5000).bitCount()}")
} catch (Throwable ex) {
    println("Caught ${ex.class.name}")
}

println()

def factorialV2

factorialV2 = { int number, BigInteger theFactorial ->
    number == 1 ? theFactorial :
            factorialV2.trampoline(number - 1, number * theFactorial)
}.trampoline()

// factorial of 5 is 120
// Number of bits in the result is 24654
println("factorial of 5 is ${factorialV2(5, 1)}")
println("Number of bits in the result is ${factorialV2(5000, 1).bitCount()}")

println()

def factorialV3(int factorialFor) {
    def tailFactorial

    tailFactorial = { int number, BigInteger theFactorial = 1 ->
        number == 1 ? theFactorial :
                tailFactorial.trampoline(number - 1, number * theFactorial)
    }.trampoline()

    tailFactorial(factorialFor)
}

// factorial of 5 is 120
// Number of bits in the result is 24654
println("factorial of 5 is ${factorialV3(5)}")
println("Number of bits in the result is ${factorialV3(5000).bitCount()}")
