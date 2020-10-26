package com.moqi.ch15

/**
 * 使用 Expando 创建动态类
 *
 * @author moqi On 10/26/20 11:07
 */
carA = new Expando()
carB = new Expando(year: 2012, miles: 0)
carA.year = 2012
carA.miles = 10

println("carA = $carA")
println("carB = $carB")

car = new Expando(year:2012, miles:0, turn: {println('turning')})
car.drive = {
    miles += 10
    println("$miles miles driven")
}

car.drive()
car.turn()

