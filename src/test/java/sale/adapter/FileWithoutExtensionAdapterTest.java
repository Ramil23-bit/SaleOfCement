package sale.adapter;

import com.example.sale.adapter.FileOrderAdapter;
import com.example.sale.adapter.FileWithoutExtensionAdapter;
import com.example.sale.entity.Order;
import com.example.sale.exception.AdapterException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
