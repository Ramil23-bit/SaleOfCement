package sale.order;

import sale.service.FileOrderAdapter;
import sale.service.FileOrderService;
import sale.service.OrderService;

import java.io.IOException;
import java.util.List;

public class OrderManager {
    private final FileOrderAdapter fileOrderAdapter;
    private final OrderService orderService;
    private final FileOrderService fileOrderService;

    public OrderManager(FileOrderService fileService, FileOrderAdapter fileAdapter, OrderService serviceOrder){
        this.fileOrderAdapter = fileAdapter;
        this.orderService = serviceOrder;
        this.fileOrderService = fileService;
    }

    public void handle(String fileToRead, String fileToWrite, int percentage, int discountPercentage) throws IOException {
        List<String> readFile = fileOrderService.read(fileToRead);
        List<Order> orderList = fileOrderAdapter.toOrders(readFile);
        List<OrderReport>reports = orderService.orderProcessing(orderList, percentage, discountPercentage);
        fileOrderService.write(reports, fileToWrite);
    }

}
