package com.moqi.ch18;

/**
 * Java A01Car
 *
 * @author moqi On 10/27/20 17:22
 */

public class A01Car {

    private int miles;

    public int getMiles() {
        return miles;
    }

    public void drive(int dist) {
        miles += dist;
    }

}
