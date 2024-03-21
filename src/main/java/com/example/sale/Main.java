package com.example.sale;

import com.example.sale.manager.OrderManager;
import com.example.sale.service.CheckFileExtensionService;
import com.example.sale.service.FileOrderService;
import com.example.sale.service.OrderService;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        OrderManager manager = new OrderManager(new FileOrderService(),new CheckFileExtensionService(), new OrderService());
        manager.handle("/discount_day.txt", "/new_list_order.txt", 50, 5);
    }
}
