package com.moqi.ch03

/**
 * 使得 remove 具有正确的行为
 *
 * @author moqi* On 9/27/20 21:19
 */
class A02UsingCollection {

    static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>()
        Collection<String> col = lst

        lst.add("one")
        lst.add("two")
        lst.add("three")

        lst.remove(0)
        col.remove(0)

        System.out.println("Added three items, removed two, so 1 item to remain.")
        System.out.println("Number of elements is: " + lst.size())
        System.out.println("Number of elements is: " + col.size())
    }

}
