package com.moqi.ch19

/**
 * ExpandoMetaClass 与 DSL
 *
 * @author moqi On 10/28/20 10:27
 */
Integer.metaClass {
    getDays = { ->
        delegate
    }

    getAgo = { ->
        def date = Calendar.instance
        date.add(Calendar.DAY_OF_MONTH, -delegate)
        date
    }
}

Calendar.metaClass.at = { Map time ->
    def hour = 0
    def minute = 0

    time.each { key, value ->
        hour = key.toInteger()
        minute = value.toInteger()
    }


    delegate.set(Calendar.HOUR_OF_DAY, hour)
    delegate.set(Calendar.MINUTE, minute)
    delegate.set(Calendar.SECOND, 0)
    delegate.time
}

println 10.days.ago.at(11:59)