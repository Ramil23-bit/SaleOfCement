package sale.service;

import com.example.sale.service.CheckFileExtensionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CheckFileExtensionServiceTest {

    @Test
    public void checkFile_shouldReturnNull_ifInputNull(){
        CheckFileExtensionService check = new CheckFileExtensionService();
        assertThrows(IllegalArgumentException.class, ()-> check.checkFile(""),
                "Параметр не может быть NULL");
    }


}
