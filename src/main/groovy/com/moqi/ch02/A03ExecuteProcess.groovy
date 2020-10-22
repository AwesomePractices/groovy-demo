package com.moqi.ch02

/**
 * GDK 一瞥
 *
 * @author moqi On 9/24/20 22:02
 */
class A03ExecuteProcess {

    static void main(String[] args) {
        println "git help".execute().text
        println()

        // java.lang.ProcessImpl
        println "git help".execute().getClass().name
        println()

        // Groovy Version: 3.0.5 JVM: 1.8.0_242 Vendor: AdoptOpenJDK OS: Mac OS X
        println "groovy -v".execute().text
        println()

        // It work on Unix like System.
        println "ls -l /Users".execute().text
    }

}
