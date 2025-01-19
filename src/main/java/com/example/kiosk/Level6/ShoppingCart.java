package com.example.kiosk.Level6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShoppingCart {
    private List<MenuItem> cartList = new ArrayList<>();
  //  private List<MenuItem> lastCartList = new ArrayList<>();// 중복값을 제거한 장바구니 메뉴

    private MenuItem cartItem;
    private double totalPrice = 0;
    private double discount;


    public ShoppingCart() {

    }

    public double disCount(int identity) {

        Discount ds = Discount.GENERAL;
        switch (identity) {
            case 1:
                ds = Discount.NATIONALMERIT;
                break;
            case 2:
                ds = Discount.SOIDIER;
                break;
            case 3:
                ds = Discount.STUDENT;
                break;
            case 4:
                ds = Discount.GENERAL;
                break;
            default:
                System.out.println("메뉴에 있는 번호를 입력해주세요.");
                break;
        }
        discount = totalPrice - (totalPrice * ((double) ds.getDiscount() * 0.01));

        return discount;
    }

    public void printDiscount() {
//        Discount ds;

        int num = 0;
        for (Discount dc : Discount.values()) {
            num++;
            System.out.print(num + ". ");
            System.out.println(dc.getIdentity() + ": " + dc.getDiscount() + "%");
        }
//
//        System.out.println("국가유공자: " + discount.getDiscount());
//        System.out.println("군인: " + discount.getDiscount();
//        System.out.println("학생: " + discount.getDiscount();
//        System.out.println("일반: " + discount.getDiscount();

    }

    public double sumPrice() {

        totalPrice = 0;

        for (MenuItem item : cartList)
            totalPrice += item.getPrice();

        return totalPrice;
    }

    public void addCartItem(MenuItem item) {

        if (cartList.stream().noneMatch(i -> i.equals(item))) {
            cartList.add(item);
        }
        //cartList.add(item);

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

    public void subCartMenu(int i) {
        // lastCartList.stream().filter(item -> lastCartList.get(i - 1)).forEach(item -> item.printMenuItem2());
        //  lastCartList = lastCartList.stream().filter(item -> item != (lastCartList.get(i - 1))).collect(Collectors.toList());
        //    lastCartList = lastCartList.stream().filter(item -> item != lastCartList.get(i - 1)).collect(Collectors.toList());
        String subName = cartList.get(i - 1).getName();
        System.out.println(subName + " 메뉴가 취소되었습니다.");
        cartList = cartList.stream().filter(item -> !item.getName().equals(subName)).collect(Collectors.toList());
//
        //   if(!item.getName().equals(subName))

    }

    public void removeCart() {
        for (MenuItem item : cartList) {
            item.setCount(0);
        }
        cartList.clear();
    }

    public void printCart() {//처음에 없는 번호 출력

        IntStream.range(0, cartList.size()).forEach(i -> cartList.get(i).setNum(i + 1));//setter은 캡슐화 컨벤션에 어긋날 수 있으므로 최대한 지양
        cartList.forEach(c -> c.printMenuItem2());

    //    lastCartList.clear();

        //IntStream.range(0, cartList.size()).forEach(i -> cartList.get(i).setNum(i + 1));
     //   cartList.stream().distinct().forEach(c -> lastCartList.add(c));
     //   IntStream.range(0, lastCartList.size()).forEach(i -> lastCartList.get(i).setNum(i + 1));//setter은 캡슐화 컨벤션에 어긋날 수 있으므로 최대한 지양
//lastCartList.forEach(c -> c.printMenuItem2());


//        System.out.println("////");
//        for (int i = 0; i < lastCartList.size(); i++) {
//            System.out.println(lastCartList.get(i).getNum() + " " + lastCartList.get(i).getName());
//        }


//  cartList.stream().filter(c -> !lastCartList.contains(c)).forEach(c -> lastCartList.add(c));
//        for (MenuItem item : cartList) {
//            if (!lastCartList.contains(item))
//                lastCartList.add(item);
//        }

//  lastCartList.stream().forEach(c -> c.printMenuItem2());
//        for (MenuItem item : lastCartList) {
//            item.printMenuItem2();
//        }
    }
}
