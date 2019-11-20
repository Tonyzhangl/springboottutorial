package com.kirago.ioc;

public class Car {

    private String name;
    private String price;
    private Wheel wheel;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Wheel getWheel() {
        return wheel;
    }
}
