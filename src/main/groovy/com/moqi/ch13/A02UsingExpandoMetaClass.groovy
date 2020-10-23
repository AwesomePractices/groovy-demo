package com.moqi.ch13

/**
 * 使用 ExpandoMetaClass 注入方法 1
 *
 * @author moqi* On 10/23/20 16:41
 */
Integer.metaClass.daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
}
println 5.daysFromNow()


Integer.metaClass.getDaysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
}
println 5.daysFromNow

println()

Integer.metaClass.'static'.isEven = {val -> val % 2 == 0}
println("Is 2 even? " + Integer.isEven(2))
println("Is 3 even? " + Integer.isEven(3))
println()

Integer.metaClass.constructor << {Calendar calendar ->
    new Integer(calendar.get(Calendar.DAY_OF_YEAR))
}
println(new Integer(Calendar.instance))
println()

Integer.metaClass.constructor = {int val ->
    println("Intercepting constructor call")
    constructor = Integer.class.getConstructor(Integer.TYPE)
    constructor.newInstance(val)
}
println(new Integer(4))
println(new Integer(Calendar.instance))

