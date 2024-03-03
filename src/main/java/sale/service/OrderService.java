package sale.service;

import sale.order.Order;
import sale.order.OrderReport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class OrderService {
    public List<OrderReport> orderProcessing(List<Order> listOrders, int percentage, int discountPercentage) throws IOException {
        List<OrderReport> reportList = new ArrayList<>();
        listOrders.sort(Comparator.comparing(Order::getDate));

        for (Order listOrder : listOrders) {
            OrderReport orderReport = new OrderReport();
            if(!(percentage <= 0)){
                int totalPrice = calculateDiscountPercentage(listOrder.getPrice(), percentage);
                orderReport.setPrice(totalPrice);
                orderReport.setCompanyName(listOrder.getCompanyName());
                percentage = percentage - discountPercentage;
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
