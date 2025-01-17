package com.example.kiosk.Level6;

public enum Discount {
    NATIONALMERIT("국가유공자", 10),
    SOIDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반", 0);


    private final String identity;
    private final int discount;

    private Discount(String identity, int discount) {
        this.identity = identity;
        this.discount = discount;
    }

    public String getIdentity() {
        return identity;
    }

    public int getDiscount() {
        return discount;
    }

}



