package sale.adapter;

import com.example.sale.adapter.FileWithoutExtensionAdapter;
import com.example.sale.entity.Order;
import com.example.sale.exception.AdapterException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileWithoutExtensionAdapterTest {
    @Test
    public void toOrders_shouldAnErrorMessage_ifInputNull(){
        FileWithoutExtensionAdapter fileAdapter = new FileWithoutExtensionAdapter();
        assertThrows(AdapterException.class, ()-> fileAdapter.toOrders(null));
    }
    @Test
    public void toOrders_shouldAnErrorMessage_ifInvalidFormatList(){
        FileWithoutExtensionAdapter fileAdapter = new FileWithoutExtensionAdapter();
        List<String> stringList = new ArrayList<>();
        stringList.add("");
        assertThrows(AdapterException.class, ()->fileAdapter.toOrders(stringList));
    }
    @Test
    public void toOrders_shouldReturnList_ifListIsEmpty(){
        FileWithoutExtensionAdapter fileAdapter = new FileWithoutExtensionAdapter();
        List<String> stringList = new ArrayList<>();
        List<Order> orderList = fileAdapter.toOrders(stringList);
        assertTrue(orderList.isEmpty());
    }
    @Test
    public void toOrders_shouldReturnListOrder_ifInputCorrectedData(){
        FileWithoutExtensionAdapter fileAdapter = new FileWithoutExtensionAdapter();
        List<String> listString = new ArrayList<>();
        listString.add("2013-03-13T18:13:54#YouHause#14000");
        listString.add("2013-03-12T09:10:04#Mebel#3265");
        listString.add("2013-03-13T12:15:32#Hause#9421");
        List<Order> orderList = fileAdapter.toOrders(listString);
        assertEquals("YouHause", orderList.get(0).getCompanyName());
        assertEquals(LocalDateTime.parse("2013-03-13T18:13:54"), orderList.get(0).getDate());
        assertEquals(14000, orderList.get(0).getPrice());
        assertEquals("Mebel", orderList.get(1).getCompanyName());
        assertEquals(LocalDateTime.parse("2013-03-12T09:10:04"), orderList.get(1).getDate());
        assertEquals(3265, orderList.get(1).getPrice());
        assertEquals("Hause", orderList.get(2).getCompanyName());
        assertEquals(LocalDateTime.parse("2013-03-13T12:15:32"), orderList.get(2).getDate());
        assertEquals(9421, orderList.get(2).getPrice());
    }
}
