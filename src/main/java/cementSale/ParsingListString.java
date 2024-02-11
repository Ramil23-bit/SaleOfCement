package cementSale;

import java.util.ArrayList;
import java.util.List;

public class ParsingListString {
    public static List<Orders> parseListString(List<String> listString){
        List<Orders> resultList = new ArrayList<>();

        for(String line : listString){
            String [] ordersFile = line.split("\\|");
            Orders orders = new Orders();
            orders.setDate(ordersFile[0]);
            orders.setNameCompany(ordersFile[1]);
            Integer price = Integer.parseInt(ordersFile[2]);
            orders.setAmountCement(price);

            resultList.add(orders);
        }

        return resultList;
    }

}
