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
    private final CheckFileExtensionService checkFile;
    private final OrderService orderService;
    private final FileOrderService fileOrderService;
    public OrderManager(FileOrderService fileService, CheckFileExtensionService checkFile, OrderService serviceOrder){
        this.checkFile = checkFile;
        this.orderService = serviceOrder;
        this.fileOrderService = fileService;
    }


    public void handle(String fileToRead, String fileToWrite ,int percentage, int discountPercentage) throws IOException {
        OrderAdapter orderAdapter = checkFile.checkFile(fileToRead);
        List<String> readFile = fileOrderService.read(fileToRead);
        List<Order> orderList = orderAdapter.toOrders(readFile);
        List<OrderReport> reports = orderService.orderProcess(orderList, percentage, discountPercentage);
        fileOrderService.write(reports, fileToWrite);
    }

}
