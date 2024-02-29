package sale.order;

import sale.service.FileOrderAdapter;
import sale.service.FileOrderService;
import sale.service.OrderService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderManager {
    final FileOrderAdapter fileOrderAdapter;
    final OrderService orderService;
    final FileOrderService fileOrderService;

    public OrderManager(FileOrderService fileService, FileOrderAdapter fileAdapter, OrderService serviceOrder){
        this.fileOrderAdapter = fileAdapter;
        this.orderService = serviceOrder;
        this.fileOrderService = fileService;
    }

    public void readFile() throws IOException {
        List<String> readFile = fileOrderService.readFilesWithCompanies("/discount_day.txt");
        List<Order> orderList = fileOrderAdapter.toOrders(readFile);
        List<OrderReport>reports = orderService.orderProcessing(orderList, 50, 5);
        fileOrderService.writeFinalListToFile(reports, "/new_list_order.txt");
    }

}
