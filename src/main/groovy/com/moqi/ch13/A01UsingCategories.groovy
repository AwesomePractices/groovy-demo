package com.moqi.ch13

/**
 * 使用分类注入方法
 *
 * @author moqi* On 10/23/20 16:26
 */
class A01StringUtil {
    // 如果想将参数限制为 String 类型，则使用 toSSN(String self)
    def static toSSN(self) {
        if (self.size() == 9) {
            "${self[0..2]}-${self[3..4]}-${self[5..8]}"
        }
    }
}

use(A01StringUtil) {
  println "123456789".toSSN()
  println new StringBuilder("987654321").toSSN()
}

try {
  println "123456789".toSSN()
} catch(MissingMethodException ex) {
  println ex.message
}
println()

@Category(String)
class A01StringUtilAnnotated {
    def toSSN() {
        if (size() == 9) {
            "${this[0..2]}-${this[3..4]}-${this[5..8]}"
        }
    }
}

use(A01StringUtilAnnotated) {
    println("123456789".toSSN())
}
println()

class A01FindUtil {
    def static extractOnly(String self, closure) {
        def result = ''
        self.each {
            if (closure(it)) {result += it}
        }
        result
    }
}

use(A01FindUtil) {
    println("121254123".extractOnly{it == '4' || it == '5'})
}
println()

use(A01StringUtil, A01FindUtil) {
    str = "123487651"
    println(str.toSSN())
    println(str.extractOnly {it == '8' || it == '1'})
}
println()

class A01Helper {
    def static toString(String self) {
        def method = self.metaClass.methods.find {it.name == 'toString'}
        '!!' + method.invoke(self, null) + '!!'
    }
}

use(A01Helper) {
    println('hello world'.toString())
}
