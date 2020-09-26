package com.moqi;

/**
 * Java Bean
 *
 * @author moqi
 * On 9/26/20 20:10
 */

public class A07JavaCar {

    private int miles;
    private final int year;

    public A07JavaCar(int year) {
        this.year = year;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public int getYear() {
        return year;
    }

    public static void main(String[] args) {
        A07JavaCar car = new A07JavaCar(2008);

        System.out.println("Year: " + car.getYear());
        System.out.println("Miles: " + car.getMiles());
        System.out.println("Setting miles");
        car.setMiles(25);
        System.out.println("Miles: " + car.getMiles());
    }

}
