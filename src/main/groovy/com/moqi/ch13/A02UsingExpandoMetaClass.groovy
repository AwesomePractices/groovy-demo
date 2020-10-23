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
