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
