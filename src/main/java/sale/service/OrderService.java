package sale.service;

import sale.order.Order;
import sale.order.OrderReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderService extends WriteDataToListObjectService {
    public List<OrderReport> orderProcessing(List<Order> listOrders, int percentage, int discountPercentage) throws IOException {
        for (Order listOrder : listOrders) {
            if(!(percentage <= 0)){
                int totalPrice = calculateDiscountPercentage(listOrder.getPrice(), percentage);
                listOrder.setPrice(totalPrice);
                percentage = percentage - discountPercentage;
            }
        }
        List<OrderReport>reportList = listOrders.stream()
                .map(r->new OrderReport(r.getCompanyName(), r.getPrice()))
                .collect(Collectors.toList());
        writeFinalListToFile(reportList);

        return reportList;
    }

    private void writeFinalListToFile(List<OrderReport> reportList) throws IOException {
        String path1 = Objects.requireNonNull(this.getClass().getResource("/new_list_order.txt")).getPath();
        File file = new File(path1);
        FileWriter writer = new FileWriter(file);
        for(OrderReport result : reportList){
            String name = result.getCompanyName();
            Integer price = result.getPrice();
            writer.write(name + " - " + price);
            writer.write("\n");
        }
        writer.close();
    }

    private int calculateDiscountPercentage(int price, int percentage){
        int resultPercentage = (price * percentage) / 100;
        return price - resultPercentage;
    }
}
