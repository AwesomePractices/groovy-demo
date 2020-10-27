package com.moqi.ch18

/**
 * 使用 Expando 实现模拟
 *
 * @author moqi On 10/27/20 19:03
 */
class A09ClassWithDependency {

    final String OUTPUT_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/output.txt"

    def methodA(val, file) {
        file.write("The value is ${val}.")
    }

    def methodB(val) {
        def file = new java.io.FileWriter(OUTPUT_PATH)
        file.write("The value is ${val}.")
    }

    def methodC(val) {
        def file = new java.io.FileWriter(OUTPUT_PATH)
        file.write("The value is ${val}.")
        file.close()
    }

}
