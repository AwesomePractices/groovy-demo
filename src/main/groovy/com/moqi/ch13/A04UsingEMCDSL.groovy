package com.moqi.ch13

/**
 * ExpandoMetaClass DSL 方法
 *
 * @author moqi* On 10/23/20 17:18
 */
Integer.metaClass {
    dayFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }

    getDaysFromNow = { ->
        Calendar today = Calendar.instance
        today.add(Calendar.DAY_OF_MONTH, delegate)
        today.time
    }

    'static' {
        isEven = { val -> val % 2 == 0 }
    }

    constructor = { Calendar calendar ->
        new Integer(calendar.get(Calendar.DAY_OF_YEAR))
    }

    constructor = { int val ->
        println("Intercepting constructor call")
        constructor = Integer.class.getConstructor(Integer.TYPE)
        constructor.newInstance(val)
    }
}