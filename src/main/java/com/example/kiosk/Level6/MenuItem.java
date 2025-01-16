package com.example.kiosk.Level6;

public class MenuItem {

    private String name;
    private double price;
    private String info;
    private int count = 0;// 장바구니용 수량

    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public int getCount() {
        return count;
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

    public void printMenuItem2() {
        System.out.println(name + "  | " + price + "  | " + info + "  |  수량: " + count);
    }

    public void countNum() {
        count++;
    }

}
