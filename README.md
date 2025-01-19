# 📱CH2.키오스크 과제

## 📚목차 
 1. 프로젝트 소개
 2. 개발 기간
 3. 개발 환경
 4. 기능 설명
 

## 1️⃣ 프로젝트 소개

사용자에게 상품을 판매하는 메뉴를 보여주고 계산하는 프로그램입니다.

## 2️⃣ 개발 기간

2025.1.13~2025.1.20 7일

## 3️⃣ 개발 환경
- IntellyJ IDEA
- JDK 17
- corretto 17.0.3
- Gradle

## 4️⃣ 기능 구현
###  🚶‍♀️ 필수 기능 가이드

- [ ]  **햄버거 메뉴 출력 및 선택하기**
    - [ ]  `Scanner`를 사용하여 여러 햄버거 메뉴를 출력합니다.
    
    ```java 
            System.out.println("[ SHAKESHACK MENU ]");

            for (int i = 0; i < menu.size(); i++) {//메뉴 출력
                if (menu.get(i).equals("종료")) {//종료는
                    System.out.println("0." + menu.get(i));//0번을 붙여서 마지막에 출력
                } else {
                    System.out.println(i+1 + "." + menu.get(i));//그 외에는 번호를 붙여서 출력(실제 인덱스는 0번부터이므로 +1)
                }
            }```
    
    - [ ]  제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성합니다.
    ```java
           System.out.println("수정하고 싶은 메뉴 번호를 입력하세요. 종료는 0");

            num = sc.nextInt();//수정번호 입력받아서

            ...
            
            else {
                System.out.println("수정할 햄버거 정보를 입력하세요.");
                a = sc2.nextLine();
                menu.set(num - 1, a);//그 외에는 수정
            }```
            
    - [ ]  반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료합니다.
    ```java
           if (num == 0)//0번이면 종료
                break; 
              ...
                
            System.out.println("프로그램을 종료합니다.");
     ```

####  - 실행결과

![](https://velog.velcdn.com/images/gkinfn/post/11bf84f8-0b76-4afd-be77-cceca387dedb/image.PNG)

 ![](https://velog.velcdn.com/images/gkinfn/post/3320a269-e03d-4f7f-9426-e572055ccc8a/image.PNG)

### Lv 2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기


- [ ]  **`MenuItem` 클래스 생성하기**
    - [ ]  설명 : 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.
    - [ ]  클래스는 `이름`, `가격`, `설명` 필드를 갖습니다.
     

 ```java 
     public class MenuItem {
 ```


  |자료형|역할|
  |--|--|
  |name : String |  상품명|
  |price : double |상품  가격|
  |info : String |상품 정보|
    
  
    
- [ ]  `main` 함수에서 `MenuItem` 클래스를 활용하여 햄버거 메뉴를 출력합니다.
    - [ ]  `MenuItem` 객체 생성을 통해 `이름`, `가격`, `설명`을 세팅합니다.
       
        
```java
 public static void main(String[] args){
 
 
        MenuItem m1=new MenuItem("ShackBurger" ,6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem m2=new MenuItem("SmokeShack" ,8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem m3=new MenuItem("Cheeseburger" ,6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem m4=new MenuItem("Hamburger" ,5.4, "비프패티를 기반으로 야채가 들어간 기본버거");  ```
        
```
- [ ]  `List`를 선언하여 여러 `MenuItem`을 추가합니다.
   
```java
        List<MenuItem> menuItems = new ArrayList<>();
```

        
- [ ]  반복문을 활용해 `menuItems`를 탐색하면서 하나씩 접근합니다.
    
```java
      while(true) {
            num=1;//1번부터 시작
            System.out.println("[ SHAKESHACK MENU ]");

            for (MenuItem menu : menuItems) {//리스트의 MenuItem의 필드들 출력
                System.out.println(num + ". " + menu.name + "  | " + menu.price + "  | " + menu.info);
                num++;
            }
            System.out.println("0. 종료");

```

### Lv 3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기

- [ ]  **요구사항이 가지는 의도**
    - [ ]  객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
    - [ ]  `main` 함수에서 관리하던 전체 순서 제어를 `Kiosk` 클래스를 통해 관리합니다.
    
- [ ]  **`Kiosk` 클래스 생성하기**

    - [ ]  **설명**: 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
    
    - [ ]  `MenuItem`을 관리하는 리스트가 필드로 존재합니다.
     

```java 
      public class Kiosk {
            
         ...
```


  |자료형|역할|
  |--|--|
  |menuItems : List<MenuItem> | 계산 결과값을 저장|
  |k : int  | 사용자 입력 값 변수 |  

   
  
    
- [ ]  `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리합니다.
 
```java
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
```
  
- [ ]  `List<MenuItem> menuItems` 는 `Kiosk` 클래스 생성자를 통해 값을 할당합니다.
```java 
    public Kiosk(List menuItems) {
        this.menuItems = menuItems;
    }
``` 
- [ ]  `Kiosk` 객체를 생성하고 사용하는 `main` 함수에서 객체를 생성할 때 값을 넘겨줍니다.
```java
      public static void main(String[] args){
    ....

        Kiosk kiosk=new Kiosk(menuItems);//메뉴 리스트를 키오스크에 추가
```

### Lv2, Lv3 실행결과

    
   ![](https://velog.velcdn.com/images/gkinfn/post/03955444-5bae-420e-8503-25182a857d3c/image.PNG)
  
   ![](https://velog.velcdn.com/images/gkinfn/post/f01ea726-2021-45da-9834-fe6bb2d78716/image.PNG)
  
### Lv 4. 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기

- [ ]  **`Menu` 클래스 생성하기**
    - [ ]  설명 : MenuItem 클래스를 관리하는 클래스입니다. 
    예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 `MenuItem`을 포함합니다.
  
    - [ ]  `List<MenuItem>` 은 `Kiosk` 클래스가 관리하기에 적절하지 않으므로 Menu 클래스가 관리하도록 변경합니다.
  
    - [ ]  여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 `카테고리 이름` 필드를 갖습니다.
  
    - [ ]  메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 합니다.


```java
public class Menu {

  
  |자료형|역할|
  |--|--|
  |name : String  | 메뉴 카테고리 명 | 
  |menuItems : List<MenuItem> | 메뉴의 상품 배열|
```  
```java   
  ....
      public String getName() {
        return name;
    }

```
  
### Lv 5. 캡슐화 적용하기

- [ ]  `MenuItem`, `Menu` 그리고 `Kiosk` 클래스의 필드에 직접 접근하지 못하도록 설정합니다.
  
```java
 private 명령어 붙이기
```
- [ ]  Getter와 Setter 메서드를 사용해 데이터를 관리합니다.

```java
public class MenuItem {
  
     private String name;
     private double price;
     private String info;
  
   ...
  
   public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInfo(String info) {
        this.info = info;
    }
  
```
  
###  Lv. 4, Lv.5 실행 결과
  ![](https://velog.velcdn.com/images/gkinfn/post/00fdfb96-373f-4b29-aeda-83082cf97ba4/image.PNG)

  
## 🏃‍♀️도전 기능 가이드

### Lv 1. 장바구니 및 구매하기 기능을 추가하기

- [ ]  **요구사항이 가지는 의도**
    - [ ]  **의도**: 클래스 간 연계를 통해 객체 지향 프로그래밍의 기본적인 설계를 익히고, 사용자 입력에 따른 프로그램 흐름 제어와 상태 관리를 학습
    - [ ]  **목표**
        - [ ]  클래스 간 역할 분리를 이해하고, 적절히 협력하는 객체를 설계
        - [ ]  프로그램 상태 변경 및 데이터 저장을 연습
        - [ ]  사용자 입력에 따른 예외 처리와 조건 분기를 연습

---

- [ ]  **장바구니 생성 및 관리 기능**
    - [ ]  사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공합니다.
```java
  
else if (subInputNumber <= menuList.getMenuItems().size()) { //서브메뉴 번호를 선택한 경우
       System.out.print("선택한 메뉴: ");
       selectItem = (MenuItem) menuList.getMenuItem(subInputNumber - 1);
       selectItem.printMenuItem();

       System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
       System.out.println("1.확인");
       System.out.println("2.취소");
              int c = sc.nextInt();```
```
 - [ ]  장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회할 수 있어야 합니다.  
                                                         
```java 
                                                         
public class ShoppingCart {
                                                         
                                                         ...
                                                         
```

  |자료형|역할|
  |--|--|
  |- cartItem : MenuItem| 장바구니 상품 리스트 |
  |- totalPrice : double| 장바구니 상품 총액 |
                                                         


- [ ]  사용자가 잘못된 선택을 했을 경우 예외를 처리합니다(예: 유효하지 않은 메뉴 번호 입력)

```java
else if (subInputNumber > menuList.getMenuItems().size()) { //메뉴에 있는 번호 이상을 입력하면
                            System.out.println("메뉴에 있는 번호를 입력하세요.");
                            continue;//세부메뉴
                        }
                    }
                }
 } catch (InputMismatchException e) { //실수로 문자를 입력했을 때 에러 처리
                System.out.println("잘못된 입력입니다. 정수를 입력하세요.");
                sc.nextLine(); // 입력 버퍼 정리
            }
```
                                                         
  
- [ ]  **장바구니 출력 및 금액 계산**
  
    - [ ]  사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력합니다.
  
```java
System.out.println("아래와 같이 주문 하시겠습니까?");
cartList.printCart();
String sum = String.format("%.1f", cartList.sumPrice());

System.out.println("[ Total ]");
System.out.println("W " + sum);

```
 
- [ ]  **장바구니 담기 기능**
    - [ ]  메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 “추가”, “취소” 처리합니다.
```java
 else if (subInputNumber <= menuList.getMenuItems().size()) { //서브메뉴 번호를 선택한 경우
   System.out.print("선택한 메뉴: ");
   selectItem = (MenuItem) menuList.getMenuItem(subInputNumber - 1);
   selectItem.printMenuItem();

   System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
   System.out.println("1.확인");
   System.out.println("2.취소");
           int c = sc.nextInt();
                                     ...                     
 ```


                                                         
- [ ]  **주문 기능**
                                                          
 - [ ]  장바구니에 담긴 모든 항목을 출력합니다.
 - [ ]  합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니를 초기화합니다.  
```java
 System.out.println("주문이 완료되었습니다. 금액은 W " + sum + " 입니다.");
 cartList.removeCart();
 System.out.println("메인메뉴로 돌아갑니다.");
```
  
### Lv 2. Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리

- [ ]  **요구사항이 가지는 의도**
    - [ ]  **의도** : 고급 자바 기능을 활용해 프로그램의 효율성과 코드의 가독성을 개선하는 것을 목표로 합니다.
    - [ ]  **목적**
        - [ ]  Enum을 통해 상수를 안전하게 관리하고, 프로그램 구조를 간결하게
        - [ ]  제네릭을 활용하여 데이터 유연성을 높이고, 재사용 가능한 코드를 설계
        - [ ]  스트림 API를 사용하여 데이터를 필터링하고, 간결한 코드로 동작을 구현

---

- [ ]  **Enum을 활용한 사용자 유형별 할인율 관리하기**
    - [ ]  사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용
        - [ ]  예시 : 군인, 학생, 일반인
                                                          
```java 
public enum Discount {
    NATIONALMERIT("국가유공자", 10),
    SOIDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반", 0);

```                                                
                                                          
- [ ]  주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산


```java 
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
```                                                         
                                                          
                                                          
- [ ]  **람다 & 스트림을 활용한 장바구니 조회 기능**
    - [ ]  기존에 생성한 Menu의 MenuItem을 조회 할 때 스트림을 사용하여 출력하도록 수정
```java
 public void printCart() {//처음에 없는 번호 출력

       ...
        cartList.forEach(c -> c.printMenuItem2());
```                                                          
                                                          
- [ ]  기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용
```java
String subName = cartList.get(i - 1).getName();
cartList = cartList.stream().filter(item -> !item.getName().equals(subName)).collect(Collectors.toList());
```

  
### 도전과제 실행결과
![](https://velog.velcdn.com/images/gkinfn/post/1764db3e-6a16-4e09-88f0-9fcbe2665761/image.PNG)
  
![](https://velog.velcdn.com/images/gkinfn/post/62c78153-7f4b-4d52-95c7-f904f086c174/image.PNG)
  
![](https://velog.velcdn.com/images/gkinfn/post/57e9235a-8d1a-4bd8-a1b9-7049cee1f42e/image.PNG)

  
 ## 5️⃣ 다이어그램 
  1) 필수과제 클래스 다이어그램
  
  2) 도전과제 클래스 다이어그램
  
  
  
  
  
 ## 6️⃣ 프로그램 사용법
1.사용자는 키오스크 메인메뉴에서 주문하고 싶은 상품 카테고리 번호를 입력한다.
  
 ![](https://velog.velcdn.com/images/gkinfn/post/15a67434-c180-47b2-9e7f-fb0f6a9abf3e/image.PNG)


2.상품 메뉴에서 주문하고 싶은 상품의 번호를 입력한다.
  
![](https://velog.velcdn.com/images/gkinfn/post/0cb91355-54b4-4a30-80bb-9460684e1a97/image.PNG)


3.상품의 상세정보를 확인 후, 장바구니에 담을지를 선택한다.
  
![](https://velog.velcdn.com/images/gkinfn/post/e5778818-5f85-4d6f-a45c-9827e470dfee/image.PNG)

4.확인 번호를 입력하면, 장바구니에 상품이 추가 되고, 다시 상품 메뉴가 출력된다.
  (취소를 누르면 장바구니에 상품이 추가 되지 않는다.)
  
![](https://velog.velcdn.com/images/gkinfn/post/c24480ce-b2a6-4c04-b1ef-fb16ba9fb563/image.PNG)

5.주문하고 싶은 상품을 모두 주문 후, 0.뒤로가기 번호를 입력하면(0번을 입력할 때까지 계속 반복) 메인메뉴가 출력된다. 장바구니에 상품이 담긴 경우, 추가 메뉴가 생성된다.

![](https://velog.velcdn.com/images/gkinfn/post/30e70109-0db2-422f-911b-4de2dd0d4720/image.PNG)

6. 4.주문하고 번호를 입력하면, 장바구니에 담긴 상품명과 수량, 총 금액이 순서대로 뜨고 사용자는 주문할지 선택한다.
 
  ![](https://velog.velcdn.com/images/gkinfn/post/08cedeb2-34fe-4016-893b-7183dee2a251/image.PNG)

7. 사용자 유형에 따른 할인율이 나오고, 사용자가 번호를 입력하면 총 금액에서 할인율이 적용된 금액으로 주문이 된다. 
  
  ![](https://velog.velcdn.com/images/gkinfn/post/9a4c687f-d54c-4356-b5c5-5403e6913ccf/image.PNG)
  
8. 주문이 끝나면, 다시 메인메뉴가 출력되고, 장바구니 상품은 없어졌으므로, 추가메뉴가 생성되지 않는다. 다시 상품 구매로 돌아간다.
 
  ![](https://velog.velcdn.com/images/gkinfn/post/36155628-75c1-4156-bc96-a563ef8a51f9/image.PNG)

9. 만약 장바구니에서 특정 상품을 빼고 싶다면, 2. 취소를 입력한 후, 취소할 상품의 번호를 입력한다.

  ![](https://velog.velcdn.com/images/gkinfn/post/f002d497-1bbb-4996-a411-59372400a6ad/image.PNG)

10.장바구니에서 해당 상품이 삭제되고, 메인메뉴로 돌아간다. 

![](https://velog.velcdn.com/images/gkinfn/post/a4825c36-e13a-443b-80eb-0fc6ea8d39c1/image.PNG)

11.다시 주문하면, 해당 상품이 삭제된 것을 확인할 수 있다.

 ![](https://velog.velcdn.com/images/gkinfn/post/b662681a-0be8-4455-a50f-999d3760a8f5/image.PNG)
 
12. 5.Cancel을 입력하면, 장바구니 상품이 모두 삭제되어, 메인메뉴만 출력된다. 
  ![](https://velog.velcdn.com/images/gkinfn/post/f0d7eb9a-4995-441d-8ba5-76f288e5d991/image.PNG)
  
13. 0. 종료를 입력하면 키오스크 프로그램이 종료된다
  ![](https://velog.velcdn.com/images/gkinfn/post/9a3be02a-b610-4aed-b929-39d17cb88d26/image.PNG)



## 7️⃣예외처리  
  
 사용자에게 번호를 입력받을 때, 메뉴에 없는 번호나, 문자를 입력하면 경고문이 뜨고, 다시 메뉴가 출력된다.  
  
  ![](https://velog.velcdn.com/images/gkinfn/post/8074bbd4-30ec-4f9f-aa48-7a8997d18c9f/image.PNG)


  
  
 ## 8️⃣ 어려웠던 점
  1. 시간분배를 잘했으면 마감 시간에 쫓길 일이 없었을텐데,  나름 시간분배해야지 했는데도 결국 실패했다.
  2. 도전과제를 하면서 알고리즘 공부가 많이 필요함을 느꼈다. 단순한 기능이라도 코드로 번역하는 것은 복잡했다. 
  3. 상품메뉴에서 상품 번호를 입력하고 결과를 출력하면, 메인메뉴로 바로 돌아가는 문제가 있어, 상품메뉴로 돌아가기 위해 시간을 많이 소모했다. 

 

  
 ## 9️⃣ 아쉬웠던 점
  1. 과제의 요구사항대로 자바가 객체 지향 언어라는 걸 충분히 학습하고 과제를 구현했으면 다른 결과물이 나왔을 것 같아서 아쉬웠다.
  2. start()에 모든 기능을 집어넣어 개발자도 협업자도 읽기 힘든 코드가 되었다.  반복되는 부분들을 메소드로 따로 빼내면 좋았을텐데, 공부도 부족했고 시간도 부족해서 결국 마무리 짓지 못했다.
  3. 다른 분들의 완성된 코드들을 많이 읽어두면 코드 완성도가 더 높아졌을 것 같다.
 
  

  


 # 🎊 읽어주셔서 감사합니다.

 
  
 ### 💻연락처
- Email: gkinfn@gmail.com
- GitHub: @bopeep934

  
  





 # 🎊 읽어주셔서 감사합니다.

 
  
 ### 💻연락처
- Email: gkinfn@gmail.com
- GitHub: @bopeep934
