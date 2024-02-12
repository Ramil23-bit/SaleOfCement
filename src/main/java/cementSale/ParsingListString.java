package cementSale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ParsingListString {
    public static List<Orders> parseListString(List<String> listString) throws ParseException {
        List<Orders> resultList = new ArrayList<>();
        Collections.sort(listString);
        for(String line : listString){
            String [] ordersFile = line.split("\\|");
            Orders orders = new Orders();
            LocalDateTime date = LocalDateTime.parse(ordersFile[0]);
            orders.setDate(date);
            orders.setNameCompany(ordersFile[1]);
            Integer price = Integer.parseInt(ordersFile[2]);
            orders.setOrderPrice(price);

            resultList.add(orders);
        }
        return resultList;
    }

}
