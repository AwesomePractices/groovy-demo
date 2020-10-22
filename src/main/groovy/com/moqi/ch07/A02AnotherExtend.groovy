package com.moqi.ch07

/**
 * 其他扩展
 *
 * @author moqi On 10/21/20 17:37
 */
int[] arr1 = [1, 2, 3, 4, 5, 6]
println(arr1[2..4])
println()

process1 = "wc".execute()
process1.out.withWriter {
    // 将输入发送到进程
    it << "Let the world know...\n"
    it << "Groovy Rocks!\n"
}
println(process1.in.text)
println()

// fixme command1.execute().text 未打印出任何东西
String[] command1 = ['groovy', '-e', '"print \'Groovy\'"']
println("Calling ${command1.join(' ')}")
println(command1.execute().text)
println()

def printThreadInfo(msg) {
    def currentThread = Thread.currentThread()
    println("$msg Thread is ${currentThread}: Daemon? ${currentThread.isDaemon()}")
}
printThreadInfo('Main')

Thread.start {
    printThreadInfo("Started")
    sleep(3000) {
        println("Interrupted")
    }
    println("Finished Started")
}

sleep(1000)

Thread.startDaemon {
    printThreadInfo("Started Daemon")
    sleep(5000) {
        println("Interrupted")
    }
    // 不会执行到这里
    println("Finished Started Daemon")
}
println()



