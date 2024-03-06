package com.example.sale.manager;

import com.example.sale.adapter.OrderAdapter;
import com.example.sale.entity.Order;
import com.example.sale.entity.OrderReport;
import com.example.sale.service.CheckFileExtensionService;
import com.example.sale.service.OrderService;
import com.example.sale.service.FileOrderService;

import java.io.IOException;
import java.util.List;
public class OrderManager {
    private final CheckFileExtensionService checkingFile;
    private final OrderService orderService;
    private final FileOrderService fileOrderService;
    public OrderManager(FileOrderService fileService, CheckFileExtensionService checkingFile, OrderService serviceOrder){
        this.checkingFile = checkingFile;
        this.orderService = serviceOrder;
        this.fileOrderService = fileService;
    }
    public void handle(String fileToRead, String fileToWrite, int percentage, int discountPercentage) throws IOException {
        CheckFileExtensionService checking = new CheckFileExtensionService();
        OrderAdapter orderAdapter = checking.checkingFile(fileToRead);
        List<String> readFile = fileOrderService.read(fileToRead);
        List<Order> orderList = orderAdapter.toOrders(readFile);
        List<OrderReport> reports = orderService.orderProcessing(orderList, percentage, discountPercentage);
        fileOrderService.write(reports, fileToWrite);


    }

}
