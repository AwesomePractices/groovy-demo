package com.moqi.ch04

/**
 * 向闭包传递多个参数
 *
 * @author moqi* On 10/3/20 14:59
 */
static def tellFortune(closure) {
    closure new Date("09/20/2012"), "your day is filled with ceremony."
}

tellFortune() {date, fortune ->
    println("Fortune for ${date} is '${fortune}'")
}

tellFortune() {Date date, String fortune ->
    println("Fortune for ${date} is '${fortune}'")
}
