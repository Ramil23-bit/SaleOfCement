package com.example.sale.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class Order {
    private LocalDateTime date;
    private String companyName;
    private Integer price;
    public Order(){}

    public Order(LocalDateTime date, String companyName, Integer price) {
        this.date = date;
        this.companyName = companyName;
        this.price = price;
    }
}
