package com.example.sale.service;

import com.example.sale.entity.Order;
import com.example.sale.entity.OrderReport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class OrderService {
    public List<OrderReport> orderProcessing(List<Order> listOrders, int discount, int discountStep) throws IOException {
        List<OrderReport> reportList = new ArrayList<>();
        listOrders.sort(Comparator.comparing(Order::getDate));
        int totalPrice;

        for (Order listOrder : listOrders) {
            OrderReport orderReport = new OrderReport();
            if(!(discount <= 0)){
                totalPrice = calculateDiscountPercentage(listOrder.getPrice(), discount);
                orderReport.setPrice(totalPrice);
                orderReport.setCompanyName(listOrder.getCompanyName());
                discount = discount - discountStep;
            } else {
                orderReport.setCompanyName(listOrder.getCompanyName());
                orderReport.setPrice(listOrder.getPrice());
            }
            reportList.add(orderReport);
        }

        return reportList;
    }


    private int calculateDiscountPercentage(int price, int percentage){
        int resultPercentage = (price * percentage) / 100;
        return price - resultPercentage;
    }


}
