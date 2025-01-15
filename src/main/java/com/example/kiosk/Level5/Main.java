package com.example.kiosk.Level5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menu = makeMenu();
//메뉴 리스트 만들기
        Kiosk kiosk = new Kiosk(menu);
//메뉴 리스트를 키오스크에 추가
        kiosk.start();
//키오스크 시작
    }

    public static List makeMenu() {//메뉴 만들기. 왜 static을 붙여야 하지?

        List<MenuItem> burgers = new ArrayList<>();
        List<MenuItem> drinks = new ArrayList<>();
        List<MenuItem> desserts = new ArrayList<>();

        MenuItem m1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem m2 = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem m3 = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem m4 = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
//햄버거 메뉴 개발
        burgers.add(m1);
        burgers.add(m2);
        burgers.add(m3);
        burgers.add(m4);
//버거 메뉴 리스트에 추가.
        MenuItem d1 = new MenuItem("코카콜라", 1700, "시원한 콜라입니다.");
        MenuItem d2 = new MenuItem("아메리카노", 1000, "차가운 아이스입니다. 뜨거운 음료는 점원에게 말씀해주세요.");
        MenuItem d3 = new MenuItem("환타 오렌지", 1700, "환타 오렌지입니다.");
        MenuItem d4 = new MenuItem("망고 에이드", 1500, "망고맛이 나는 에이드입니다.");
//음료 메뉴 개발
        drinks.add(d1);
        drinks.add(d2);
        drinks.add(d3);
        drinks.add(d4);
//음료 메뉴 리스트에 추가
        MenuItem c1 = new MenuItem("치즈스틱", 1000, "치즈가 가득 들어있습니다.");
        MenuItem c2 = new MenuItem("어니언링", 2000, "양파튀김입니다.");
        MenuItem c3 = new MenuItem("프렌치프라이", 1600, "감자튀김입니다.");
        MenuItem c4 = new MenuItem("바삭킹", 10000, "치킨윙입니다.");
//사이드 메뉴 개발
        desserts.add(c1);
        desserts.add(c2);
        desserts.add(c3);
        desserts.add(c4);
//사이드 메뉴 리스트에 추가
        Menu menu1 = new Menu("burgers", burgers);
        Menu menu2 = new Menu("drinks", drinks);
        Menu menu3 = new Menu("desserts", desserts);
//메뉴에 추가
        List<Menu> menu = new ArrayList<>();
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
//메뉴 리스트 생성 후 추가

        return menu;

    }
}
