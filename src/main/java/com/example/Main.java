package com.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();


        list.add(4);

        list.add(2);

        list.add(3);

        list.add(1);


// 컬렉션에서 스트림 생성

        Stream<Integer> a = list.stream();

// forEach() 메소드를 이용한 스트림 요소의 순차 접근

        a.forEach(System.out::println);
        //이걸 풀자면 for(int i=0;i<list.size();i++)
        //. System.out.println(a.get(i)); 이거지?
        // a.forEach(System.out::println); OK
    }
}


