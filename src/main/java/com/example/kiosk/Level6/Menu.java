package com.example.kiosk.Level6;

import java.util.List;

public class Menu<T> {
    private String name;
    //private List<MenuItem> menuIte;
    private List<T> menuItems;

    //Stream<MenuItem> list = menuItems.stream();

    public Menu(String name, List<T> menuItems) {
        this.name = name;
        this.menuItems = menuItems;
    }

    public String getName() {

        return name;
    }

    public List<T> getMenuItems() {

        return menuItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuItems(List<T> menuItems) {
        this.menuItems = menuItems;
    }

    public void printMenu() {
        int num = 1;//1번부터 시작
        System.out.println("[ " + name.toUpperCase() + " MENU ]");

        //   menuItems.stream().forEach(System.out::println);

        for (T menu : menuItems) {//리스트의 MenuItem의 필드들 출력
            System.out.print(num + ". ");
            MenuItem mi = (MenuItem) menu;
            mi.printMenuItem();
            num++;
        }
        System.out.println("0. 뒤로가기");
        //  System.out.println("num:" + num);
    }

    public T getMenuItem(int i) {

        return menuItems.get(i);
    }

}

