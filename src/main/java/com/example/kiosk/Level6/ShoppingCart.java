package com.example.kiosk.Level6;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<MenuItem> cartList = new ArrayList<>();
    private MenuItem cartItem;
    private double totalPrice = 0;

    public ShoppingCart() {

    }

    public double sumPrice() {
        for (MenuItem item : cartList)
            totalPrice += item.getPrice();

        return totalPrice;
    }

    public void addCartItem(MenuItem item) {
        cartList.add(item);
    }

    public List getCartMenu() {
        if (cartList.size() > 0)
            return cartList;
        else
            return null;
    }

    public void setCartMenu(List<MenuItem> cartMenu) {
        this.cartList = cartMenu;
    }

    public void removeCart() {
        cartList.clear();
    }

//    public void printCart(int num) {//처음에 번호 있는 출력
//        System.out.println("[ ORDER MENU ]");
//        for (MenuItem item : cartList) {
//            System.out.print(num + ". ");
//            item.printMenuItem();
//            num++;
//        }
//    }

    public void printCart() {//처음에 없는 번호 출력
        for (MenuItem item : cartList) {
            item.printMenuItem();
        }
    }
}
