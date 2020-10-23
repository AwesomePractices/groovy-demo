package com.moqi.ch13

/**
 * 使用 ExpandoMetaClass 注入方法 2
 *
 * @author moqi* On 10/23/20 17:08
 */
daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, (int)delegate)
    today.time
}

Integer.metaClass.daysFromNow = daysFromNow
Long.metaClass.daysFromNow = daysFromNow

println(5.daysFromNow())
println(15L.daysFromNow())

Number.metaClass.someMethod = { ->
    println("Some Method Called")
}

2.someMethod()
200L.someMethod()
