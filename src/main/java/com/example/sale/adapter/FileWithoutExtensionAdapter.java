package com.example.sale.adapter;

import com.example.sale.entity.Order;
import com.example.sale.exception.AdapterException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileWithoutExtensionAdapter implements OrderAdapter{
    @Override
    public List<Order> toOrders(List<String> listString) {
        List<Order> resultList = new ArrayList<>();
        if (listString == null) {
            throw new AdapterException("Список не может быть NULL");
        }
        for(String line : listString){
            String [] ordersFile = line.split("\\#");
            Order orders = new Order();
            if (ordersFile[0].equals("")){
                throw new AdapterException("Не верный формат нулевого индекса");
            }
            LocalDateTime date = LocalDateTime.parse(ordersFile[0]);
            orders.setDate(date);
            orders.setCompanyName(ordersFile[1]);
            Integer price = Integer.parseInt(ordersFile[2]);
            orders.setPrice(price);
            resultList.add(orders);
        }
        return resultList;
    }

}
