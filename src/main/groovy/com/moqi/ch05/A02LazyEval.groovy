package com.moqi.ch05

/**
 * GString 的惰性求值问题
 *
 * @author moqi On 10/5/20 10:05
 */
price = 684.71
company = 'Google'
quote = "Today $company stock closed at $price"
// Today Google stock closed at 684.71
println(quote)

stocks = [Apple: 663.01, Microsoft: 30.95]

// Today Google stock closed at 684.71
// Today Google stock closed at 684.71
stocks.each { k, v ->
    company = k
    price = v
    println(quote)
}
println()

companyClosure = { it.write(company) }
priceClosure = { it.write("$price") }
newQuote = "Today ${companyClosure} stock closed at ${priceClosure}"

// Today Apple stock closed at 663.01
// Today Microsoft stock closed at 30.95
stocks.each { k, v ->
    company = k
    price = v
    println(newQuote)
}
println()


companyClosureV2 = { -> company }
priceClosureV2 = { -> price }
newQuoteV2 = "Today ${companyClosureV2} stock closed at ${priceClosureV2}"

// Today Apple stock closed at 663.01
// Today Microsoft stock closed at 30.95
stocks.each { k, v ->
    company = k
    price = v
    println(newQuoteV2)
}
println()


newQuoteV3 = "Today ${-> company} stock closed at ${-> price}"

// Today Apple stock closed at 663.01
// Today Microsoft stock closed at 30.95
stocks.each { k, v ->
    company = k
    price = v
    println(newQuoteV3)
}
println()
