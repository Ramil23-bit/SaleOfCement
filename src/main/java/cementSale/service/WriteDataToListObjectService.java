package cementSale.service;

import cementSale.order.Order;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WriteDataToListObjectService {
    public  List<Order> toOrders(List<String> listString) {
        List<Order> resultList = new ArrayList<>();
        sortListOrderToDate(listString);
        for(String line : listString){
            String [] ordersFile = line.split("\\|");
            Order orders = new Order();
            LocalDateTime date = LocalDateTime.parse(ordersFile[0]);
            orders.setDate(date);
            orders.setCompanyName(ordersFile[1]);
            Integer price = Integer.parseInt(ordersFile[2]);
            orders.setPrice(price);

            resultList.add(orders);
        }
        return resultList;
    }

    public void sortListOrderToDate(List<String> list){
        Collections.sort(list);
    }
}
