package com.moqi

/**
 * 读取属性使用点的方式，而无需使用访问器和更改器
 *
 * @author moqi* On 9/26/20 20:41
 */
// 代替 Calendar.getInstance()
calender = Calendar.instance
println calender

str = 'hello'

/**
 * 代替 str.getClass().name
 * 注意：不能用于 Map、Builder 等类型
 * 为保险起见，请使用 str.getClass().name
 */
println str.class.name
