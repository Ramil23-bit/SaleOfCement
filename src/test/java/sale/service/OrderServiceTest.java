package sale.service;

import com.example.sale.entity.Order;
import com.example.sale.entity.OrderReport;
import com.example.sale.exception.OrderServiceException;
import com.example.sale.service.OrderService;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class OrderServiceTest {

    @Test
    public void orderProcess_shouldReturnError_ifInputInvalidData(){
        OrderService orderService = new OrderService();
        List<Order> orderList = Collections.emptyList();
        assertThrows(OrderServiceException.class, ()-> orderService.orderProcess(orderList, 0, 0));
    }
    @Test
    public void orderProcess_shouldReturnError_ifInputNull(){
        OrderService orderService = new OrderService();
        assertThrows(NullPointerException.class, ()->orderService.orderProcess(null, 0, 0));
    }
    @Test
    public void orderProcess_shouldReturnList_ifListIsEmpty() throws IOException {
        OrderService orderService = new OrderService();
        List<Order> orderList = new ArrayList<>();
        List<OrderReport> report = orderService.orderProcess(orderList, 30, 2);
        assertTrue(report.isEmpty());
    }
    @Test
    public void orderProcess_shouldReturnList_ifDiscountStepMoreDiscount() {
        OrderService orderService = new OrderService();
        List<Order> orders = new ArrayList<>();
        assertThrows(OrderServiceException.class, ()->orderService.orderProcess(orders, 20, 25));
    }
    @Test
    public void orderProcess_shouldReturnError_ifInputNegativeNumbers(){
        OrderService orderService = new OrderService();
        assertThrows(NullPointerException.class, ()->orderService.orderProcess(null, -24, -3));
    }
    @Test
    public void orderProcess_shouldReturnList_ifInputCorrectedData() throws IOException {
        OrderService orderService = new OrderService();
        List<Order> orders = new ArrayList<>();
        Order order = new Order(LocalDateTime.parse("2013-03-12T09:10:04"),"Hause", 2000);
        Order order1 = new Order(LocalDateTime.parse("2013-03-12T13:11:14"),"Dom", 4300);
        Order order2 = new Order(LocalDateTime.parse("2013-03-12T11:11:04"),"Mebel", 7500);
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        List<OrderReport> reports = orderService.orderProcess(orders, 15, 5);
        assertEquals("Hause", reports.get(0).getCompanyName());
        assertEquals(1700, reports.get(0).getPrice());
        assertEquals("Mebel", reports.get(1).getCompanyName());
        assertEquals(6750, reports.get(1).getPrice());
        assertEquals("Dom", reports.get(2).getCompanyName());
        assertEquals(4085, reports.get(2).getPrice());
    }
    @Test
    public void orderProcess_shouldReturnList_ifDiscountStepZero() throws IOException {
        OrderService orderService = new OrderService();
        List<Order> orders = new ArrayList<>();
        Order order = new Order(LocalDateTime.parse("2013-03-12T09:10:04"),"Hause", 2000);
        Order order1 = new Order(LocalDateTime.parse("2013-03-12T13:11:14"),"Dom", 4300);
        Order order2 = new Order(LocalDateTime.parse("2013-03-12T11:11:04"),"Mebel", 7500);
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        List<OrderReport> reports = orderService.orderProcess(orders, 15, 0);
        assertEquals(1700, reports.get(0).getPrice());
        assertEquals(6375, reports.get(1).getPrice());
        assertEquals(3655, reports.get(2).getPrice());
    }
}
