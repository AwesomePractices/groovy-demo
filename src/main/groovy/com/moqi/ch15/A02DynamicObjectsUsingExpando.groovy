package com.moqi.ch15

/**
 * 动态对象
 *
 * @author moqi On 10/26/20 11:20
 */
data = new File("/Users/moqi/Code/groovy-demo/src/main/resources/car.bat").readLines()

props = data[0].split(', ')
data -= data[0]

def averageMilesDrivenPerYear = {miles.toLong() / (2008 - year.toLong())}

cars = data.collect {
    car = new Expando()
    it.split(', ').eachWithIndex { String value, int index ->
        car[props[index]] = value
    }

    car.ampy = averageMilesDrivenPerYear

    car
}

props.each {name -> print("$name ")}
println(" Avg. MPY")
ampyMethod = 'ampy'
cars.each {car ->
    for (String property: props) {
        print("${car[property]} ")
    }
    println(car."$ampyMethod"())
}

// 你也可能想通过名字访问属性或方法
car = cars[0]
println("$car.miles $car.year $car.make ${car.ampy()}")
