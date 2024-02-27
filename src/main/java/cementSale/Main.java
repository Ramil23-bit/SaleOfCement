package cementSale;

import cementSale.order.Order;
import cementSale.service.FileOrderService;
import cementSale.service.OrderService;
import cementSale.service.WriteDataToListObjectService;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        OrderService m = new OrderService();
        FileOrderService readFile = new FileOrderService();
        WriteDataToListObjectService writeData = new WriteDataToListObjectService();
        m.orderProcessing(writeData.toOrders(readFile.readingFilesWithCompanies()), 50, 5);
    }
}
