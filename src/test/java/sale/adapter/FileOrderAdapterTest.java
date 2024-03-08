package sale.adapter;


import com.example.sale.adapter.FileOrderAdapter;
import com.example.sale.entity.Order;
import com.example.sale.exception.AdapterException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileOrderAdapterTest {
    @Test
    public void toOrders_shouldAnErrorMessage_ifInputNull(){
        FileOrderAdapter fileAdapter = new FileOrderAdapter();
        assertThrows(AdapterException.class, ()-> fileAdapter.toOrders(null));
    }
    @Test
    public void toOrders_shouldAnErrorMessage_ifInvalidFormatList(){
        FileOrderAdapter fileAdapter = new FileOrderAdapter();
        List<String> stringList = new ArrayList<>();
        stringList.add("");
        assertThrows(AdapterException.class, ()->fileAdapter.toOrders(stringList));
    }
    @Test
    public void toOrders_shouldReturnList_ifListIsEmpty(){
        FileOrderAdapter fileAdapter = new FileOrderAdapter();
        List<String> stringList = new ArrayList<>();
        List<Order> orderList = fileAdapter.toOrders(stringList);
        assertTrue(orderList.isEmpty());
    }

}
