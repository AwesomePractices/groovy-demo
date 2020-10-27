package com.moqi.ch16

/**
 * 创建一个可以注入 use 方法的 Resource 类
 *
 * @author moqi On 10/27/20 10:41
 */
@A05EAM
class Resource {
    private def open() {print("opened...")}
    private def close() {print("closed...")}
    def read() {print("read...")}
    def write() {print("write...")}
}


println("Using Resource")

Resource.use {
    read()
    write()
}