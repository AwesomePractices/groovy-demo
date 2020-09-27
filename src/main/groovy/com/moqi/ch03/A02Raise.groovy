package com.moqi.ch03

/**
 * 动态调用方法
 *
 * @author moqi* On 9/27/20 21:10
 */
static void giveRaise(A02JavaEmployee employee) {
    employee.raise(new BigDecimal("10000.00"))
}

giveRaise(new A02JavaEmployee())
giveRaise(new A02JavaExecutive())



