package sale.service;

import com.example.sale.adapter.OrderAdapter;
import com.example.sale.service.CheckFileExtensionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckFileExtensionServiceTest {
    @Test
    public void checkFile_shouldReturnNull_ifInputNull() {
        CheckFileExtensionService check = new CheckFileExtensionService();
        assertThrows(IllegalArgumentException.class, () -> check.checkFile(""),
                "Параметр не может быть NULL");
    }
    @Test
    public void checkFile_shouldReturnBoolean_ifCorrectType() {
        CheckFileExtensionService check = new CheckFileExtensionService();
        assertTrue(check.checkFile("/discount_day") instanceof OrderAdapter);
    }
    @Test
    public void checkFile_shouldReturnErrorMessage_ifInputNull() {
        CheckFileExtensionService check = new CheckFileExtensionService();
        assertThrows(IllegalArgumentException.class, () -> check.checkFile(null));
    }
}
