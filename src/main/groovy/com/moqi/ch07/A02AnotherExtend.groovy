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
    sleep(300) {
        println("Interrupted")
    }
    println("Finished Started")
}

sleep(100)

Thread.startDaemon {
    printThreadInfo("Started Daemon")
    sleep(500) {
        println("Interrupted")
    }
    // 不会执行到这里
    println("Finished Started Daemon")
}
println()



final String THOREAU_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/thoreau.txt"
final String OUTPUT_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/output.txt"

println(new File(THOREAU_PATH).text)
println()

new File(THOREAU_PATH).eachLine {line ->
    // 或者在这里执行自己想对该行进行的任何处理
    println("line = " + line)
}
println()

println(new File(THOREAU_PATH).filterLine {it =~ /life/})
println()

new File(OUTPUT_PATH).withWriter {file ->
    file << "some data........"
}
