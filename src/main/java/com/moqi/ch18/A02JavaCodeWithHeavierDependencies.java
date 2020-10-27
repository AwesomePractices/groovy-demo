package com.moqi.ch18;

/**
 * Java CodeWithHeavierDependencies
 *
 * @author moqi On 10/27/20 17:47
 */

public class A02JavaCodeWithHeavierDependencies {

    public int someAction() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            // do nothing
        }

        return (int) (Math.random() * 100);
    }

    public void myMethod() {
        int value = someAction() + 10;
        System.out.println(value);
    }

}
