package com.moqi.ch04

/**
 * 使用闭包进行资源清理 01
 *
 * @author moqi On 10/3/20 15:06
 */
def outputTxtFile = '/Users/moqi/Downloads/output.txt'
writer = new FileWriter(outputTxtFile)
writer.write('!')
// 忘记调用 writer.close()


new FileWriter(outputTxtFile).withWriter { writer ->
    writer.write('!!!')
} // 不再需要自己调用 close()
