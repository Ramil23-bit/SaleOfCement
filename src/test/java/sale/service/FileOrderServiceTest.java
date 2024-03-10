package sale.service;

import com.example.sale.exception.OrderServiceException;
import com.example.sale.exception.ServiceException;
import org.junit.Test;
import com.example.sale.service.FileOrderService;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static org.junit.jupiter.api.Assertions.*;

public class FileOrderServiceTest {
    @Test
    public void read_shouldAnErrorMessage_ifInvalidFileName(){
        FileOrderService file = new FileOrderService();
        assertThrows(NoSuchFileException.class, () -> file.read("/discou-day_test.txt"));
    }
    @Test
    public void read_shouldAnErrorMessage_ifFileNameNull(){
        FileOrderService file = new FileOrderService();
        assertThrows(OrderServiceException.class, ()->file.read(null));
    }
    @Test
    public void read_shouldMessage_ifNoFileName(){
        FileOrderService file = new FileOrderService();
        assertThrows(AccessDeniedException.class, ()->file.read(""));
    }
    @Test
    public void read_shouldCorrectedFileFormat_ifInvalidFormatEntered(){
        FileOrderService file = new FileOrderService();
        assertThrows(NoSuchFileException.class, () -> file.read("/discount_day.img"));
    }
    @Test
    public void read_shouldReturnMessage_ifFileEmpty() throws IOException {
        FileOrderService file = new FileOrderService();
        assertTrue(file.read("/discount_day_test.txt").isEmpty());
    }
    @Test
    public void read_shouldReturnFile_ifFileHasContent() throws IOException {
        FileOrderService file = new FileOrderService();
        List<String> list = new ArrayList<>();
        list.add("2021-02-09T16:00:22|Industrial|8800");
        list.add("2021-02-09T08:42:59|Power Engineer|17480");
        list.add("2021-02-09T10:48:34|Mosque|33120");
        assertEquals(list.get(0),file.read("/discount_test.txt").get(0));
        assertEquals(list.get(1),file.read("/discount_test.txt").get(1));
        assertEquals(list.get(2),file.read("/discount_test.txt").get(2));
    }
}
