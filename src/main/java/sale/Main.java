package sale;

import sale.order.OrderManager;
import sale.service.FileOrderAdapter;
import sale.service.FileOrderService;
import sale.service.OrderService;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException {
        OrderManager manager = new OrderManager(new FileOrderService(),new FileOrderAdapter(), new OrderService());
        manager.readFile();
    }
}
