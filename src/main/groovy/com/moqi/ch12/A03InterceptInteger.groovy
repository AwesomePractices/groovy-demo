package com.moqi.ch12

/**
 * MetaClass 拦截 Integer 上的方法调用
 *
 * @author moqi* On 10/23/20 15:25
 */
Integer.metaClass.invokeMethod = { String name, args ->
    System.out.println("")
    System.out.println("Call to $name intercepted on $delegate... ")

    def validMethod = Integer.metaClass.getMetaMethod(name, args)
    if (validMethod == null) {
        Integer.metaClass.invokeMissingMethod(delegate, name, args)
    } else {
        System.out.println("running pre-filter... ")
        result = validMethod.invoke(delegate, args) // Remove this for around-advice

        System.out.println("running post-filter... ")
        result
    }
    System.out.println("")
}

println 5.floatValue()
println 5.intValue()
try {
    println 5.empty()
} catch (Exception ex) {
    println ex
}
