package sale.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileOrderService {
    public List<String> readingFilesWithCompanies() throws IOException {
        String path = Objects.requireNonNull(this.getClass().getResource("/discount_day.txt")).getPath();
        File file = new File(path);
        return Files.readAllLines(Paths.get(file.toURI()));
    }


}
