package com.example.kiosk.Level4;

public class MenuItem {
 //   int num=1;
    String name;
    double price;
    String info;

    public MenuItem(String name, double price, String info){
        this.name=name;
        this.price=price;
        this.info=info;
    }
    public void printMenuItem(){
        System.out.println( name + "  | " + price + "  | " + info);

    }

}
