package com.agiledeveloper

/**
 * 使用扩展模块定制方法
 *
 * @author moqi On 10/22/20 10:44
 */
class A03PriceExtension {

    static double getPrice(String self) {
        def url = "http://ichart.finance.yahoo.com/table.csv?s=${self}".toURL()
        def data = url.readLines()[1].split(",")
        Double.parseDouble(data[-1])
    }

}
