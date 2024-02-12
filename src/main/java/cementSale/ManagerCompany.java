package cementSale;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManagerCompany {
    private static final String FILE_PATH_DISCOUNT_DAY = "C:\\Users\\babol\\Ykul\\SaleOfCement\\src\\main\\resources\\new_price_discount_day.txt";

    public List<Orders> orderProcessing(List<Orders> listOrders) throws IOException {
        int percentage = 50;
        FileWriter writer = new FileWriter(FILE_PATH_DISCOUNT_DAY);
        for (Orders listOrder : listOrders) {
            int resultPercentage = listOrder.getOrderPrice() * percentage / 100;
            percentage = percentage - 5;
            listOrder.setOrderPrice(resultPercentage);
        }
        writer.write(listOrders.toString());
        writer.write("\n");
        writer.close();
        return listOrders;
    }
}
