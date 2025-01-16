package com.example.kiosk.Level6;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<MenuItem> cartList = new ArrayList<>();
    private List<MenuItem> lastCartList = new ArrayList<>();// 중복값을 제거한 장바구니 메뉴

    private MenuItem cartItem;
    private double totalPrice = 0;

    public ShoppingCart() {

    }

    public double sumPrice() {

        totalPrice = 0;

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
        lastCartList.clear();
    }

    public void printCart() {//처음에 없는 번호 출력

        for (MenuItem item : cartList) {
            if (!lastCartList.contains(item))
                lastCartList.add(item);
        }

        for (MenuItem item : lastCartList) {
            item.printMenuItem2();
        }
    }
}
