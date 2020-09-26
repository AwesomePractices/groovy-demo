package com.moqi

/**
 * 对 Java 5 的支持
 * 自动装箱、for-each、enum
 *
 * @author moqi* On 9/26/20 21:30
 */
int val = 5
println(val.class.name)
println()

String[] greetings = ['Hello', 'How', 'Are', 'You']
for (greet in greetings) {
    println "greet = $greet"
}
println()

enum CoffeeSize {
    SHORT, SMALL, MEDIUM, LARGE, MUG
}

def orderCoffee(size) {
    print "Coffee order received for size $size. "
    switch (size) {
        case [CoffeeSize.SHORT, CoffeeSize.SMALL]:
            println('You are health conscious')
            break
        case [CoffeeSize.MEDIUM..CoffeeSize.LARGE]:
            println('You gotta be a programmer')
            break
        case CoffeeSize.MUG:
            println('You should try Caffeine IV')
            break
    }
}

orderCoffee(CoffeeSize.SMALL)
orderCoffee(CoffeeSize.LARGE)
orderCoffee(CoffeeSize.MUG)
println 'Available sizes are: '
for (size in CoffeeSize.values()) {
    println "size = $size"
}
println()


enum Methodologies {
    Evo(5),
    XP(21),
    Scrum(30);

    final int daysInIteration

    Methodologies(days) { daysInIteration = days }

    def iterationDetails() {
        println "${this} recommends $daysInIteration days for iteration"
    }
}

for (methodology in Methodologies.values()) {
    methodology.iterationDetails()
}
println()
