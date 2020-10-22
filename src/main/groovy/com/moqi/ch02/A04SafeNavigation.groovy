package com.moqi.ch02

/**
 * 安全导航操作符
 *
 * @author moqi On 9/24/20 22:21
 */

static def foo(String str) {
    str?.reverse()
}

// live
println foo('evil')
// null
println foo(null)
