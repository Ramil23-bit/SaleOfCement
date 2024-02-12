package cementSale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    private static final String FILE_PATH_DISCOUNT_DAY = "C:\\Users\\babol\\Ykul\\SaleOfCement\\src\\main\\resources\\discount_day.txt";

    public static List<String> readingFilesWithCompanies() throws IOException {
        return Files.readAllLines(Paths.get(FILE_PATH_DISCOUNT_DAY));
    }


}
