package com.moqi

/**
 * 灵活初始化与具名参数
 *
 * @author moqi* On 9/26/20 20:46
 */
class Robot {
    def type, height, width

    static def access(location, weight, fragile) {
        println "Received fragile? $fragile, weight: $weight, loc: $location"
    }

    /**
     * 通过显示地将第一个形参指定为 Map，避免混乱
     */
    static def accessMap(Map location, weight, fragile) {
        println "Received fragile? $fragile, weight: $weight, loc: $location"
    }
}

robot = new Robot(type: 'arm', width: 10, height: 40)
println "$robot.type, $robot.height, $robot.width"

robot.access(x: 30, y: 20, z: 10, 50, true)
robot.access(50, true, x: 30, y: 20, z: 10)

robot.accessMap(x: 30, y: 20, z: 10, 50, true)
robot.accessMap(50, true, x: 30, y: 20, z: 10)
