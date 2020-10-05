package com.moqi.ch04

/**
 * 科里化闭包
 *
 * @author moqi On 10/3/20 15:53
 */
def tellFortunes(closure) {
    Date date = new Date("09/20/2012")

    /*
     * closure date, 'your day is filled with ceremony'
     * closure date, 'they are features, not bugs'
     * 可以通过科里化避免重复发送 date
     */
    postFortune = closure.curry(date)
    postFortune 'your day is filled with ceremony'
    postFortune 'they are features, not bugs'
}

tellFortunes() { date, fortune ->
    println("Fortune for ${date} is '${fortune}'")
}
