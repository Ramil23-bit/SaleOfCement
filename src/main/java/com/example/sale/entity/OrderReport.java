package com.example.sale.entity;

import lombok.*;

@Getter
@Setter
public class OrderReport {
    private String companyName;
    private Integer price;
    public OrderReport(){}

    public OrderReport(String companyName, Integer price) {
        this.companyName = companyName;
        this.price = price;
    }

    @Override
    public String toString() {
        return companyName +
                " - " +
                price + "\n";
    }
}
