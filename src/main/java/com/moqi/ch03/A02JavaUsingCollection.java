package com.moqi.ch03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author moqi
 * On 9/27/20 21:13
 */

public class A02JavaUsingCollection {

    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        Collection<String> col = lst;

        lst.add("one");
        lst.add("two");
        lst.add("three");

        lst.remove(0);
        /*
         * 本意是移除 index 为 0 的元素，但 collection 接口的 remove 接受一个 object
         * 因此 0 被强转为 Integer，但 col 中不包含数字 0，因此什么都没有移除
         */
        col.remove(0);

        System.out.println("Added three items, removed two, so 1 item to remain.");
        System.out.println("Number of elements is: " + lst.size());
        System.out.println("Number of elements is: " + col.size());
    }

}
