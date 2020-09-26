package com.moqi

/**
 * 实现循环的几种方式
 *
 * @author moqi* On 9/24/20 21:40
 */
class A02ForLoop {

    /**
     * "$it " 这里必须使用双引号，不可以使用单引号
     */
    static void main(String[] args) {
        upto()
        times()
        iterStep()
    }

    /**
     * 0 1 2
     */
    private static upto() {
        0.upto(2) {
            print "$it "
        }

        println()
    }

    /**
     * 0 1 2
     */
    private static times() {
        3.times {
            print "$it "
        }

        println()
    }

    /**
     * 0 2 4 6 8
     */
    private static iterStep() {
        0.step(10, 2) {
            print "$it "
        }

        println()
    }

}
