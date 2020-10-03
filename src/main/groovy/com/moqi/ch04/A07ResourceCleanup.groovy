package com.moqi.ch04

/**
 * 使用闭包在代码块的前后执行相应操作
 *
 * @author moqi* On 10/3/20 15:22
 */
class A07Resource {
    def open() { println('opened ...') }

    def close() { println('closed ...') }

    def read() { println('read ...') }

    def write() { println('write ...') }

    /**
     * 使用闭包在代码块的前后执行相应操作
     */
    def static use(closure) {
        def r = new A07Resource()

        try {
            r.open()
            closure(r)
        } finally {
            r.close()
        }
    }
}

def resource = new A07Resource()
resource.open()
resource.read()
resource.write()
// 忘记调用 close
println()


A07Resource.use { res ->
    res.read()
    res.write()
}
