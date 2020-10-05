package com.moqi

/**
 *
 * 异常处理
 *
 * @author moqi On 9/24/20 22:27
 */
static def openFile(String fileName) {
    new FileInputStream(fileName)
}

try {
    openFile("nonExitFile")
} catch (FileNotFoundException ex) {
    // 关于该异常，在这里想做什么就做什么
    println "Oops: " + ex
}


try {
    openFile("nonExitFile")
// 捕获所有异常（不包括 Error 或 Throwable）
} catch (ex) {
    // 关于该异常，在这里想做什么就做什么
    println "Oops: " + ex
}
