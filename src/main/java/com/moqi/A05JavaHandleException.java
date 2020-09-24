package com.moqi;

/**
 * @author moqi
 * On 9/24/20 22:25
 */

public class A05JavaHandleException {

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // 啊？这里该做什么？我都因为这个寝食难安了。
        }
    }

}
