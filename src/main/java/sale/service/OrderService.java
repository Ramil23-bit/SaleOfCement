package sale.service;

import sale.order.Order;
import sale.order.OrderReport;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class OrderService {
    public List<OrderReport> orderProcessing(List<Order> listOrders, int percentage, int discountPercentage) throws IOException {
        FileOrderService fileOrder = new FileOrderService();
        sortListOrderToDate(listOrders);
        List<OrderReport> reportList = new ArrayList<>();

        for (Order listOrder : listOrders) {
            OrderReport orderReport = new OrderReport();
            if(!(percentage <= 0)){
                int totalPrice = calculateDiscountPercentage(listOrder.getPrice(), percentage);
                orderReport.setPrice(totalPrice);
                orderReport.setCompanyName(listOrder.getCompanyName());
                percentage = percentage - discountPercentage;
            }
            reportList.add(orderReport);
        }

        fileOrder.writeFinalListToFile(reportList, "/new_list_order.txt");

        return reportList;
    }


    private int calculateDiscountPercentage(int price, int percentage){
        int resultPercentage = (price * percentage) / 100;
        return price - resultPercentage;
    }

    public void sortListOrderToDate(List<Order> list){
        list.sort((order1, order2) -> LocalDateTime.now().compareTo(order1.getDate()));
    }

}
