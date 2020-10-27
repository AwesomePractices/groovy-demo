package com.moqi.ch18

/**
 * Two File User
 *
 * @author moqi On 10/27/20 19:23
 */
class A16TwoFileUser {

    final String OUTPUT_1_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/output.txt"
    final String OUTPUT_2_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/output.txt"

    def useFiles(str) {
        def file1 = new FileWriter(OUTPUT_1_PATH)
        def file2 = new FileWriter(OUTPUT_2_PATH)

        file1.write(str)
        file2.write(str.size())
        file1.close()
        file2.close()
    }

}
