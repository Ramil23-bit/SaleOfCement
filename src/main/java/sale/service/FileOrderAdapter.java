package sale.service;

import sale.order.Order;
import sale.order.OrderAdapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileOrderAdapter implements OrderAdapter {
    @Override
    public  List<Order> toOrders(List<String> listString) {
        List<Order> resultList = new ArrayList<>();
        for(String line : listString){
            String [] ordersFile = line.split("\\|");
            Order orders = new Order();
            LocalDateTime date = LocalDateTime.parse(ordersFile[0]);
            orders.setDate(date);
            orders.setCompanyName(ordersFile[1]);
            Integer price = Integer.parseInt(ordersFile[2]);
            orders.setPrice(price);

            resultList.add(orders);
        }
        return resultList;
    }

}
