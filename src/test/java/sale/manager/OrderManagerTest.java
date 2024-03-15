package sale.manager;

import com.example.sale.adapter.FileOrderAdapter;
import com.example.sale.adapter.OrderAdapter;
import com.example.sale.entity.Order;
import com.example.sale.entity.OrderReport;
import com.example.sale.manager.OrderManager;
import com.example.sale.service.CheckFileExtensionService;
import com.example.sale.service.FileOrderService;
import com.example.sale.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class OrderManagerTest {
    @Mock
    private OrderService orderService;
    @Mock
    private FileOrderService fileOrderService;
    @Mock
    private CheckFileExtensionService check;
    @Mock
    private FileOrderAdapter fileAdapter;
    @Mock
    OrderAdapter orderAdapter;
    @Mock
    List<String> listMock;
    @Mock
    List<Order> listOrder;
    @Mock
    List<OrderReport> reportList;
    @InjectMocks
    private OrderManager orderManager;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void checkFile_shouldReturnObject_ifInputFileName() throws IOException {
        when(check.checkFile("/discount_day.txt")).thenReturn(fileAdapter);
        when(fileOrderService.read("/discount_day.txt")).thenReturn(listMock);
        when(orderAdapter.toOrders(listMock)).thenReturn(listOrder);
        when(orderService.orderProcess(listOrder,50, 5)).thenReturn(reportList);
        orderManager.handle("/discount_day.txt", "new_list_order.txt", 50, 5);
        verify(check.checkFile("/discount_day.txt"));
    }
}
