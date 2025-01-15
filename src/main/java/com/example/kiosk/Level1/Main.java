package com.example.kiosk.Level1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        ArrayList<String> menu = new ArrayList<String>();//버거메뉴 저장할 배열
        String a;//scanner 메뉴를 입력받을 변수
        int num;//수정 번호 변수


        while (true) {//종료입력할 때까지 무한으로 메뉴를 입력받는다.
            System.out.println("햄버거 메뉴를 입력하세요('종료' 입력시 종료)");
            a = sc.nextLine();
            menu.add(a);
            if (a.equals("종료"))
                break;
        }

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");

            for (int i = 0; i < menu.size(); i++) {//메뉴 출력
                if (menu.get(i).equals("종료")) {//종료는
                    System.out.println("0." + menu.get(i));//0번을 붙여서 마지막에 출력
                } else {
                    System.out.println(i+1 + "." + menu.get(i));//그 외에는 번호를 붙여서 출력(실제 인덱스는 0번부터이므로 +1)
                }
            }


            System.out.println("수정하고 싶은 메뉴 번호를 입력하세요. 종료는 0");

            num = sc.nextInt();//수정번호 입력받아서

            if (num == 0)//0번이면 종료
                break;
            else {
                System.out.println("수정할 햄버거 정보를 입력하세요.");
                a = sc2.nextLine();
                menu.set(num - 1, a);//그 외에는 수정
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

}


