package com.example.kiosk.Level6;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    static int num;

    private List<Menu> menu;

    public Kiosk(List menu) {
        this.menu = menu;
    }

    public void start() {

        Menu menuList = null;
        ShoppingCart cartList = new ShoppingCart();
        MenuItem selectItem = null;

        int k;

        Scanner sc = new Scanner(System.in);

        while (true) {
            num = 1;//1번부터 시작
            /////////////1. 메인메뉴 출력 후 입력받기
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(num + ". " + menu.get(i).getName());//후에 private-getter-setter로 생성
                num++;
            }
            System.out.println("0. 종료");
            //       System.out.println("num:" + num);
            if (cartList.getCartMenu() != null) {
                System.out.println("[ ORDER MENU ]");
                System.out.println(num + ". Orders");
                num++;
                System.out.println(num + ". Cancel");
            }


            try {
                System.out.println("보고 싶은 메인메뉴 번호를 입력하세요.");//사용자에게 입력받기
                k = sc.nextInt();

                if (k == 0) {//0번은 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (k < num) { //그 외는 다시 무한 루프
                    menuList = menu.get(k - 1);
                    menuList.printMenu(); //출력
                } else if (k == num && k == num + 1) {
                    if (cartList.getCartMenu() == null) {
                        System.out.println("메뉴에 있는 번호를 입력하세요.");
                        continue;
                    } else {
                        System.out.println("아래와 같이 주문 하시겠습니까?");
                        cartList.printCart();

                        System.out.println("[ Total ]");
                        System.out.println("W " + cartList.sumPrice());

                        System.out.println("1.주문");
                        System.out.println("2.메뉴판");

                        int m = sc.nextInt();

                        if (m == 1) {
                            System.out.println("주문이 완료되었습니다. 금액은 W " + cartList.sumPrice() + " 입니다.");
                        } else if (m == 2) {
                            continue;
                        }

                    }
                } else if (k > num + 1) { //메뉴에 있는 번호 이상을 입력하면
                    System.out.println("메뉴에 있는 번호를 입력하세요.");
                    continue;
                }
                //////////////// 2.두번째 메뉴 사용자에게 입력받기
                System.out.println("보고 싶은 메뉴 번호를 입력하세요.");
                k = sc.nextInt();

                if (k == 0) { //0번은 뒤로가기
                    continue;
                } else if (k <= menuList.getMenuItems().size()) { //
                    System.out.print("선택한 메뉴: ");
                    selectItem = menuList.getMenuItem(k - 1);
                    selectItem.printMenuItem();

                    //     System.out.println();
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1.확인");
                    System.out.println("2.취소");
                    int c = sc.nextInt();
                    if (c == 1) {
                        cartList.addCartItem(selectItem);
                        System.out.println(selectItem.getName() + " 이 장바구니에 추가되었습니다.");
                        continue;
                    } else if (c == 2) {
                        continue;//세부메뉴로 돌아가기 기능 구현하기
                    } else if (c > 2) {
                        System.out.println("메뉴에 있는 번호를 입력하세요.");//세부메뉴로 돌아가기 기능 구현하기
                    }

                } else if (k > menuList.getMenuItems().size()) { //메뉴에 있는 번호 이상을 입력하면
                    System.out.println("메뉴에 있는 번호를 입력하세요.");
                    menuList.printMenu(); //다시 상세메뉴 출력
                }
            } catch (InputMismatchException e) { //실수로 문자를 입력했을 때 에러 처리
                System.out.println("잘못된 입력입니다. 정수를 입력하세요.");
                sc.nextLine(); // 입력 버퍼 정리
            }
        }
    }
}



