/**
 * 测试扩展方法
 *
 * @author moqi On 10/22/20 10:49
 */
def ticker = "ORCL"

/**
 * 测试失败
 *
 * Caught: groovy.lang.MissingMethodException: No signature of method: static java.lang.String.getPrice() is applicable for argument types: (String) values: [ORCL]
 * Possible solutions: getBytes(java.lang.String), getAt(java.lang.String)
 * groovy.lang.MissingMethodException: No signature of method: static java.lang.String.getPrice() is applicable for argument types: (String) values: [ORCL]
 * Possible solutions: getBytes(java.lang.String), getAt(java.lang.String)
 *         at FindPrice.run(FindPrice.groovy:8)
 *
 * */
println("price for $ticker using instance method is ${String.getPrice(ticker)}")
println("Price for $ticker using static method is ${ticker.getPrice()}")
