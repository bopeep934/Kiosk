package com.example.kiosk.Level5;

public class MenuItem {
    //   int num=1;
    private String name;
    private double price;
    private String info;

    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void printMenuItem() {
        System.out.println(name + "  | " + price + "  | " + info);

    }

}
