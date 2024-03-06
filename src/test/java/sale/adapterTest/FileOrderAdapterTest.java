package sale.adapterTest;


import com.example.sale.adapter.FileOrderAdapter;
import com.example.sale.entity.Order;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;

public class FileOrderAdapterTest {
    @Test
    public void toOrders_shouldAnErrorMessage_ifInputNull(){
        FileOrderAdapter fileAdapter = new FileOrderAdapter();
        assertThrows(NullPointerException.class, ()-> fileAdapter.toOrders(null));
    }
    @Test
    public void toOrders_shouldAnErrorMessage_ifInvalidFormatList(){
        FileOrderAdapter fileAdapter = new FileOrderAdapter();
        List<String> stringList = new ArrayList<>();
        stringList.add("");
        assertThrows(DateTimeParseException.class, ()->fileAdapter.toOrders(stringList));
    }
    @Test
    public void toOrders_shouldReturnListType_ifInvalidListType(){
        FileOrderAdapter fileAdapter = new FileOrderAdapter();
        List<Order> orderList = new ArrayList<>();
        List<String>stringList = new ArrayList<>();
        assertEquals(orderList, fileAdapter.toOrders(stringList));
    }
    @Test
    public void toOrders_shouldAnErrorMessage_ifListIsEmpty(){
        FileOrderAdapter fileAdapter = new FileOrderAdapter();
        List<String>stringList = Collections.emptyList();
        List<String>list = new ArrayList<>();
        assertEquals(list,fileAdapter.toOrders(stringList));
    }

}
