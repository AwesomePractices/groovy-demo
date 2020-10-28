package com.moqi.ch19

/**
 * 闭包与 DSL
 *
 * @author moqi On 10/28/20 10:02
 */
def getPizza(closure) {
    /*PizzaShop pizzaShop = new PizzaShop()
    closure.delegate = pizzaShop
    closure()*/
}


time = getPizza {
    setSize Size.LARGE
    setCrust Crust.THIN
    setTopping "Olives", "Onions", "Bell Pepper"
    seetAddress "101 Main St., ..."
    setCart CardType.VISA, "1234-1234-1234-1234"
}

printf("Pizza will arrive in %d minutes\n", time);
