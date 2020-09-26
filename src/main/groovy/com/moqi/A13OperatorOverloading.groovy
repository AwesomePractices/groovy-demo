package com.moqi

/**
 * 操作符重载
 *
 * @author moqi* On 9/26/20 21:24
 */
for (ch = 'a'; ch < 'd'; ch++) {
    println(ch)
}
println()

for (ch in 'a'..'c') {
    println(ch)
}
println()

lst = ['hello']
lst << 'there'
println(lst)
println()

class ComplexNumber {
    def real, imaginary

    def plus(other) {
        new ComplexNumber(real: real + other.real, imaginary: imaginary + other.imaginary)
    }

    String toString() {
        "$real ${imaginary > 0 ? '+' : ''} ${imaginary}i"
    }
}

c1 = new ComplexNumber(real: 1, imaginary: 2)
c2 = new ComplexNumber(real: 4, imaginary: 1)
println(c1 + c2)

