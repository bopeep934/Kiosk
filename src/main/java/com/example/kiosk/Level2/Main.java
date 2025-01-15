package com.example.kiosk.Level2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        MenuItem m1=new MenuItem("ShackBurger" ,6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem m2=new MenuItem("SmokeShack" ,8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem m3=new MenuItem("Cheeseburger" ,6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem m4=new MenuItem("Hamburger" ,5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
//햄버거 메뉴 개발

        List<MenuItem> menuItems = new ArrayList<>();
        int num;//메뉴 번호
        int k;//메뉴 번호 입력받기 변수

        menuItems.add(m1);
        menuItems.add(m2);
        menuItems.add(m3);
        menuItems.add(m4);
//리스트에 삽입

        Scanner sc=new Scanner(System.in);
//
//        for(int i=0;i<menuItems.size();i++) {
//            System.out.println(menuItems.get(i).toString());
//        }//주소만 출력됨


        while(true) {
            num=1;//1번부터 시작
            System.out.println("[ SHAKESHACK MENU ]");

            for (MenuItem menu : menuItems) {//리스트의 MenuItem의 필드들 출력
                System.out.println(num + ". " + menu.name + "  | " + menu.price + "  | " + menu.info);
                num++;
            }
            System.out.println("0. 종료");

            System.out.println("보고 싶은 메뉴 번호를 입력하세요.");//사용자에게 입력받기

            k = sc.nextInt();

            if (k == 0) {//0번은 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{//그 외는 출력 후 다시 무한 루프
                MenuItem m=menuItems.get(k-1);
                System.out.println(k+ ". " + m.name+ "  | " + m.price+ "  | " +m.info);
                System.out.println();

            }
        }

    }

}
