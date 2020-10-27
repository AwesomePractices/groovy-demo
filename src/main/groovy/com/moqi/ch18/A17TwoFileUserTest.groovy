package com.moqi.ch18

import groovy.mock.interceptor.MockFor
import groovy.test.GroovyTestCase

/**
 * Two File User Test
 *
 * @author moqi On 10/27/20 19:25
 */
class A17TwoFileUserTest extends GroovyTestCase {

    final String OUTPUT_1_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/output.txt"
    final String OUTPUT_2_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/output.txt"


    void testUseFiles() {
        def testObj = new A16TwoFileUser()
        def testData = "Multi Files"

        def fileMOck = new MockFor(FileWriter)

        fileMOck.demand.write() { assertEquals testData, it }
        fileMOck.demand.write() { assertEquals testData.size(), it }
        fileMOck.demand.close(2..2) {}

        fileMOck.use {
            testObj.useFiles(testData)
        }
    }


    void tearDown() {
        new File(OUTPUT_1_PATH).delete()
        new File(OUTPUT_2_PATH).delete()
    }

}
