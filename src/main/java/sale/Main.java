package sale;

import sale.service.FileOrderService;
import sale.service.OrderService;
import sale.service.WriteDataToListObjectService;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        OrderService m = new OrderService();
        FileOrderService readFile = new FileOrderService();
        WriteDataToListObjectService writeData = new WriteDataToListObjectService();
        m.orderProcessing(writeData.toOrders(readFile.readingFilesWithCompanies()), 50, 5);
    }
}
