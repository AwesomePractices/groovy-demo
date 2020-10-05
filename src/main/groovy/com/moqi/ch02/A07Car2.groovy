package com.moqi

/**
 * 使用 final 和自定义 set 方法禁止变量赋值
 *
 * @author moqi On 9/26/20 20:33
 */
class A07CarPrivate {

    final year
    private miles = 0

    A07CarPrivate(theYear) { year = theYear }

    def getMiles() {
        println 'getMiles Called'
        miles
    }

    private void setMiles(miles) {
        throw new IllegalAccessException("you're not allowed to change miles")
    }

    def drive(dist) {
        if (dist > 0) {
            miles += dist
        }
    }

}


def car = new A07CarPrivate(2012)

println "year: $car.year"
println "Miles: $car.miles"
println 'Driving'
car.drive(10)
println "Miles: $car.miles"

try {
    print 'Can I set the year? '
    car.year = 1900
} catch (ReadOnlyPropertyException ex) {
    println ex.message
}

try {
    print 'Can I set the miles? '
    car.miles = 12
} catch (IllegalAccessException ex) {
    println ex.message
}
