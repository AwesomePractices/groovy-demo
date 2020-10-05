package com.moqi.ch04

import groovy.transform.*

/**
 * 使用记忆化改进性能
 *
 * @author moqi On 10/5/20 09:27
 */
def timeIt(length, closure) {
    long start = System.nanoTime()
    println("Max revenue for $length is ${closure(length)}")
    long end = System.nanoTime()
    println("Time taken ${(end - start) / 1.0e9} seconds")
}

def rodPrices = [0, 1, 3, 4, 5, 8, 9, 11, 12, 14,
                 15, 15, 16, 18, 19, 15, 20, 21, 22, 24,
                 25, 24, 26, 28, 29, 35, 37, 38, 39, 40]

def desiredLength = 27

@Immutable
class A13RevenueDetails {
    int revenue
    ArrayList splits
}

def cutRod(prices, length) {
    if (length == 0) {
        new A13RevenueDetails(0, [])
    } else {
        def maxRevenueDetails = new A13RevenueDetails(Integer.MIN_VALUE, [])

        for (rodSize in 1..length) {
            def revenueFromSecondHalf = cutRod(prices, length - rodSize)
            def potentialRevenue = new A13RevenueDetails(
                    prices[rodSize] + revenueFromSecondHalf.revenue,
                    revenueFromSecondHalf.splits + rodSize)

            if (potentialRevenue.revenue > maxRevenueDetails.revenue) {
                maxRevenueDetails = potentialRevenue
            }
        }

        maxRevenueDetails
    }
}

// Max revenue for 27 is com.moqi.ch04.A13RevenueDetails(43, [5, 5, 5, 5, 5, 2])
// Time taken 128.852986731 seconds
// timeIt desiredLength, { length -> cutRod(rodPrices, length) }
// println()

def cutRodMemoize

cutRodMemoize = { prices, length ->
    if (length == 0) {
        new A13RevenueDetails(0, [])
    } else {
        def maxRevenueDetails = new A13RevenueDetails(Integer.MIN_VALUE, [])

        for (rodSize in 1..length) {
            // 这里的循环调用一定需要更新为记忆化的函数
            def revenueFromSecondHalf = cutRodMemoize(prices, length - rodSize)
            def potentialRevenue = new A13RevenueDetails(
                    prices[rodSize] + revenueFromSecondHalf.revenue,
                    revenueFromSecondHalf.splits + rodSize)

            if (potentialRevenue.revenue > maxRevenueDetails.revenue) {
                maxRevenueDetails = potentialRevenue
            }
        }

        maxRevenueDetails
    }
}.memoize()

// Max revenue for 27 is com.moqi.ch04.A13RevenueDetails(43, [5, 5, 5, 5, 5, 2])
// Time taken 0.125177704 seconds
timeIt desiredLength, { length -> cutRodMemoize(rodPrices, length) }


