package sale.service;

import sale.order.OrderReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileOrderService {
    private final String pathToFile = Objects.requireNonNull(this.getClass().getResource("/orders")).getPath();
    public List<String> readFilesWithCompanies(String path) throws IOException {
        File file = new File(pathToFile + path);
        return Files.readAllLines(Paths.get(file.toURI()));
    }

    public void writeFinalListToFile(List<OrderReport> reportList, String path) throws IOException {
        File file = new File(pathToFile + path);
        FileWriter writer = new FileWriter(file);
        for(OrderReport result : reportList){
            String name = result.getCompanyName();
            Integer price = result.getPrice();
            writer.write(name + " - " + price);
            writer.write("\n");
        }
        writer.close();
    }
}
