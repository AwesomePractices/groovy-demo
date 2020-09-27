package com.moqi.ch03;

import java.math.BigDecimal;

/**
 * @author moqi
 * On 9/27/20 21:05
 */

public class A02JavaRaise {

    public static void giveRaise(A02JavaEmployee employee) {
        employee.raise(new BigDecimal("10000.00"));
    }

    public static void main(String[] args) {
        giveRaise(new A02JavaEmployee());
        giveRaise(new A02JavaExecutive());
    }

}

class A02JavaEmployee {
    public void raise(Number amount) {
        System.out.println("Employee got raise.");
    }
}

class A02JavaExecutive extends A02JavaEmployee {
    public void raise(Number amount) {
        System.out.println("Executive got raise.");
    }

    public void raise(BigDecimal amount) {
        System.out.println("Executive got outlandish raise.");
    }
}
