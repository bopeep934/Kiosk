package com.example.kiosk.Level6;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Kiosk {

    private int num;

    private List<Menu> menu;

    public Kiosk(List menu) {
        this.menu = menu;
    }

    public void start() {

        Menu menuList = null;
        ShoppingCart cartList = new ShoppingCart();
        MenuItem selectItem = null;

        int mainInputNumber;//메인메뉴 입력 변수
        int subInputNumber;//서브메뉴 입력 변수
        int cartInputNumber;//장바구니메뉴 입력 변수

        Scanner sc = new Scanner(System.in);

        while (true) {
            num = 1;//1번부터 시작
/////////////////////////////////////////////////////1. 메인메뉴 출력 후 입력받기
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(num + ". " + menu.get(i).getName());//후에 private-getter-setter로 생성
                num++;
            }
            System.out.println("0. 종료");
            //       System.out.println("num:" + num);


            /////////////////////////////////////// 장바구니에 메뉴아이템이 있으면 추가
            if (cartList.getCartMenu() != null) {
                System.out.println("[ ORDER MENU ]");
                System.out.println(num + ". Orders");
                num++;
                System.out.println(num + ". Cancel");
            }
////////////////////////////////////////////////////2. 사용자에게 입력받기
            try {
                System.out.println("보고 싶은 메인메뉴 번호를 입력하세요.");
                mainInputNumber = sc.nextInt();

////////////////////////////////////////////////////3. 번호에 따라 나눔
                if (mainInputNumber == 0) {//0번은 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (mainInputNumber == menu.size() + 1) {//메뉴보다 1 더 큰 번호를 입력했다면

                    if (cartList.getCartMenu() == null) {//장바구니 메뉴가 뜨지 않은데 누른 경우 에러 처리로 돌아감
                        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                        continue;
                    } else {//장바구니 메뉴 orders를 보고 입력한 경우
                        System.out.println("아래와 같이 주문 하시겠습니까?");
                        cartList.printCart();
                        String sum = String.format("%.1f", cartList.sumPrice());

                        System.out.println("[ Total ]");
                        System.out.println("W " + sum);

                        System.out.println("1.주문");
                        System.out.println("2.취소");
                        System.out.println("3.메뉴판");

                        cartInputNumber = sc.nextInt();

                        if (cartInputNumber == 1) {

                            System.out.println("할인 정보를 입력해주세요.");

                            cartList.printDiscount();

                            int d = sc.nextInt();

                            if (d < 5)
                                sum = String.format("%.1f", cartList.disCount(d));
//                            else {
//                                System.out.println("메뉴에 있는 번호를 입력하세요.");
//                            } 나중에 구현 시간부족

                            System.out.println("주문이 완료되었습니다. 금액은 W " + sum + " 입니다.");
                            cartList.removeCart();
                            System.out.println("메인메뉴로 돌아갑니다.");
                            continue;
                        } else if (cartInputNumber == 2) {
                            System.out.println("취소할 메뉴의 번호를 입력해주세요.");
                            int sub = sc.nextInt();
                            cartList.subCartMenu(sub);
                            continue;
                        } else if (cartInputNumber == 3) {
                            System.out.println("메인메뉴로 돌아갑니다.");
                            continue;
                        } else if (cartInputNumber > 3) { //메뉴에 있는 번호 이상을 입력하면
                            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                            continue;
                        }
                    }
                } else if (mainInputNumber == menu.size() + 2) {//
                    System.out.println("장바구니 상품을 모두 취소했습니다.");
                    cartList.removeCart();
                    System.out.println("메인메뉴로 돌아갑니다.");
                    continue;
                } else if (mainInputNumber > num) { //메뉴에 있는 번호 이상을 입력하면
                    System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                    continue;
                } else if (mainInputNumber <= menu.size()) {//메뉴 번호를 입력했다면
                    while (true) {//서브메뉴 루프 돌리기
                        menuList = menu.get(mainInputNumber - 1);
                        menuList.printMenu(); //출력
                        //////////////// 2.두번째 메뉴 사용자에게 입력받기
                        System.out.println("구입하고 싶은 메뉴 번호를 입력하세요.");
                        subInputNumber = sc.nextInt();

                        if (subInputNumber == 0) { //0번은 뒤로가기
                            break;//메인메뉴로 돌아감
                        } else if (subInputNumber <= menuList.getMenuItems().size()) { //서브메뉴 번호를 선택한 경우
                            System.out.print("선택한 메뉴: ");
                            selectItem = (MenuItem) menuList.getMenuItem(subInputNumber - 1);
                            selectItem.printMenuItem();

                            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                            System.out.println("1.확인");
                            System.out.println("2.취소");
                            int c = sc.nextInt();
                            if (c == 1) {
                                cartList.addCartItem(selectItem);
                                selectItem.countNum();//수량 더하기
                                System.out.println(selectItem.getName() + " 이 장바구니에 추가되었습니다.");
                            } else if (c == 2) {
                                System.out.println("메뉴로 돌아갑니다.");
                                //    continue;//세부메뉴로 돌아가기 기능 구현하기
                            } else if (c > 2) {
                                System.out.println("메뉴에 있는 번호를 입력하세요.");
                                //      continue;//세부메뉴로 돌아가기 기능 구현하기
                            }

                        } else if (subInputNumber > menuList.getMenuItems().size()) { //메뉴에 있는 번호 이상을 입력하면
                            System.out.println("메뉴에 있는 번호를 입력하세요.");
                            continue;//세부메뉴
                        }
                    }
                }
            } catch (InputMismatchException e) { //실수로 문자를 입력했을 때 에러 처리
                System.out.println("잘못된 입력입니다. 정수를 입력하세요.");
                sc.nextLine(); // 입력 버퍼 정리
            }
        }
    }
}




