package com.moqi

/**
 * Groovy Bean 1
 *
 * @author moqi* On 9/26/20 20:13
 */
class A07Car {

    def miles = 0
    final year

    A07Car(theYear) { year = theYear }

}

A07Car car = new A07Car(2008)

println "year: $car.year"
println "Miles: $car.miles"
println 'Setting miles'
car.miles = 25
println "Miles: $car.miles"
