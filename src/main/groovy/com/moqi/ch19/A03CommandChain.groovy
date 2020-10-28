package com.moqi.ch19

/**
 * 使用命令链接特性改进流畅性
 *
 * @author moqi On 10/28/20 09:57
 */
def (forward, left, then, fast, right) = ['forward', 'left', '', 'fast', 'right']

def move(dir) {
    println("moving $dir")
    this
}

def and(then) {
    this
}

def turn(dir) {
    println("turning $dir")
    this
}

def jump(speed, dir) {
    println("jumping $speed and $dir")
    this
}

// DSL test
move forward and then turn left
jump fast, forward and then turn right