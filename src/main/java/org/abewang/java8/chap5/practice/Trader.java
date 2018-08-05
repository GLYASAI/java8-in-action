package org.abewang.java8.chap5.practice;

/**
 * @Author Abe
 * @Date 2018/8/2.
 */
public class Trader {
    private final String name;

    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader:" + name + " in " + city;
    }
}
