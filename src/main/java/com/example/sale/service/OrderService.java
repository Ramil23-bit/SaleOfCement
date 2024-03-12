package com.example.sale.service;

import com.example.sale.entity.Order;
import com.example.sale.entity.OrderReport;
import com.example.sale.exception.OrderServiceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class OrderService {
    public List<OrderReport> orderProcess(List<Order> listOrders, int discount, int discountStep) throws IOException {
        if (listOrders == null) {
            throw new IllegalArgumentException("неверный данные");
        }
        List<OrderReport> reportList = new ArrayList<>();
        listOrders.sort(Comparator.comparing(Order::getDate));
        int totalPrice;
        if (listOrders.isEmpty() && discount <= 0 && discountStep <= 0) {
            throw new IllegalArgumentException("Неверные параметры");
        }
        if (discountStep > discount) {
            throw new OrderServiceException("Шаг скидки не может быть больше скидки");
        }

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
