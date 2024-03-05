package com.example.sale.manager;

import com.example.sale.adapter.FileWithoutExtensionAdapter;
import com.example.sale.adapter.OrderAdapter;
import com.example.sale.entity.Order;
import com.example.sale.entity.OrderReport;
import com.example.sale.adapter.FileOrderAdapter;
import com.example.sale.service.CheckingFileExtensionService;
import com.example.sale.service.OrderService;
import com.example.sale.service.FileOrderService;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
@Getter
@Setter
public class OrderManager {
    private final CheckingFileExtensionService checkingFile;
    private final OrderService orderService;
    private final FileOrderService fileOrderService;

    public OrderManager( FileOrderService fileService,CheckingFileExtensionService checkingFile, OrderService serviceOrder){
        this.checkingFile = checkingFile;
        this.orderService = serviceOrder;
        this.fileOrderService = fileService;
    }

    public void handle(String fileToRead, String fileToWrite, int percentage, int discountPercentage) throws IOException {
        CheckingFileExtensionService checking = new CheckingFileExtensionService();
        OrderAdapter orderAdapter = checking.checkingFile(fileToRead);

        List<String> readFile = fileOrderService.read(fileToRead);
        List<Order> orderList = orderAdapter.toOrders(readFile);
        List<OrderReport> reports = orderService.orderProcessing(orderList, percentage, discountPercentage);
        fileOrderService.write(reports, fileToWrite);


    }

}
