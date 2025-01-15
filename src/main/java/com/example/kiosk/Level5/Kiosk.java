package com.example.kiosk.Level5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private List<Menu> menu;


    public Kiosk(List menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        Menu menulist = null;
        int num;
        int k;
        while (true) {
            num = 1;//1번부터 시작
            /////////////1. 메인메뉴 출력 후 입력받기
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(num + ". " + menu.get(i).getName());//후에 private-getter-setter로 생성
                num++;
            }
            System.out.println("0. 종료");
            System.out.println("num:" + num);

            try {
                System.out.println("보고 싶은 메인메뉴 번호를 입력하세요.");//사용자에게 입력받기
                k = sc.nextInt();

                if (k == 0) {//0번은 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (k < num) { //그 외는 다시 무한 루프
                    menulist = menu.get(k - 1);
                    menulist.printMenu(); //출력
                } else if (k >= num) { //메뉴에 있는 번호 이상을 입력하면
                    System.out.println("메뉴에 있는 번호를 입력하세요.");
                    continue;
                }
                //////////////// 2.두번째 메뉴 사용자에게 입력받기
                System.out.println("보고 싶은 메뉴 번호를 입력하세요.");
                k = sc.nextInt();

                if (k == 0) { //0번은 뒤로가기
                    continue;
                } else if (k <= menulist.getMenuItems().size()) { //
                    System.out.print("선택한 메뉴: ");
                    menulist.getMenuItem(k - 1).printMenuItem();
                } else if (k > menulist.getMenuItems().size()) { //메뉴에 있는 번호 이상을 입력하면
                    System.out.println("메뉴에 있는 번호를 입력하세요.");
                    menulist.printMenu(); //다시 상세메뉴 출력
                }
            } catch (InputMismatchException e) { //실수로 문자를 입력했을 때 에러 처리
                System.out.println("잘못된 입력입니다. 정수를 입력하세요.");
                sc.nextLine(); // 입력 버퍼 정리
            }
        }
    }
}



