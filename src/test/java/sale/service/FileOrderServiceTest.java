package sale.service;

import org.junit.Test;
import com.example.sale.service.FileOrderService;

import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FileOrderServiceTest {

    @Test
    public void readFile_shouldAnErrorMessage_ifInvalidFileName(){
        FileOrderService file = new FileOrderService();
        assertThrows(NoSuchFileException.class, () -> file.read("/discou-day.txt"));
    }

    @Test
    public void readFile_shouldMessage_ifNoFileName(){
        FileOrderService file = new FileOrderService();
        assertThrows(AccessDeniedException.class, ()->file.read(""));
    }

    @Test
    public void readFile_shouldCorrectedFileFormat_ifInvalidFormatEntered(){
        FileOrderService file = new FileOrderService();
        assertThrows(NoSuchFileException.class, () -> file.read("/discount_day.img"));
    }
}
