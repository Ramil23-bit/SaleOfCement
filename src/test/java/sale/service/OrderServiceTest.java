package sale.service;

import com.example.sale.entity.Order;
import com.example.sale.entity.OrderReport;
import com.example.sale.exception.OrderServiceException;
import com.example.sale.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    @Test
    public void orderProcess_shouldReturnError_ifInputInvalidData(){
        OrderService orderService = new OrderService();
        List<Order> orderList = Collections.emptyList();
        assertThrows(OrderServiceException.class, ()-> orderService.orderProcess(orderList, 0, 0));
    }

    @Test
    public void orderProcess() throws IOException {
        OrderService orderService = new OrderService();
        List<Order> orderList = new ArrayList<>();
        List<OrderReport> report = orderService.orderProcess(orderList, 30, 2);
        Assertions.assertTrue(report.isEmpty());
    }
}
