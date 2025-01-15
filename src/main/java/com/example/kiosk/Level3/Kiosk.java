package com.example.kiosk.Level3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    List<MenuItem> menuItems;
    int num;
    int k;

    public Kiosk(List menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            num = 1;//1번부터 시작
            System.out.println("[ SHAKESHACK MENU ]");

            for (MenuItem menu : menuItems) {//리스트의 MenuItem의 필드들 출력
                System.out.println(num + ". " + menu.name + "  | " + menu.price + "  | " + menu.info);
                num++;
            }
            System.out.println("0. 종료");
            try {
                System.out.println("보고 싶은 메뉴 번호를 입력하세요.");//사용자에게 입력받기

                k = sc.nextInt();
           //     System.out.println("k:" + k);


                if (k == 0) {//0번은 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (k < num) {//그 외는 출력 후 다시 무한 루프
                    MenuItem m = menuItems.get(k - 1);
                    System.out.println(k + ". " + m.name + "  | " + m.price + "  | " + m.info);
                    System.out.println();
                } else if (k >= num) {
                    System.out.println("메뉴에 있는 번호를 입력하세요.");
                    //throw new IllegalArgumentException("메뉴에 있는 번호를 입력하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력하세요.");
                sc.nextLine(); // 입력 버퍼 정리
            }
        }
    }
}

