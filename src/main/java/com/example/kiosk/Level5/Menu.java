package com.example.kiosk.Level5;

import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> menuItems;

    public Menu(String name, List menuItems) {
        this.name = name;
        this.menuItems = menuItems;
    }

    public String getName() {

        return name;
    }

    public List<MenuItem> getMenuItems() {

        return menuItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void printMenu() {
        int num = 1;//1번부터 시작
        System.out.println("[ " + name.toUpperCase() + " MENU ]");
        for (MenuItem menu : menuItems) {//리스트의 MenuItem의 필드들 출력
            System.out.print(num + ". ");
            menu.printMenuItem();
            num++;
        }
        System.out.println("0. 뒤로가기");
        //  System.out.println("num:" + num);
    }

    public MenuItem getMenuItem(int i) {
        return menuItems.get(i);
    }

}
