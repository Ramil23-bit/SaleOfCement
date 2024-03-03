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

    public List<String> read(String fileName) throws IOException {
        File file = new File(pathToFile + fileName);
        return Files.readAllLines(Paths.get(file.toURI()));
    }

    public void write(List<OrderReport> reportList, String fileName){
        File file = new File(pathToFile + fileName);
        try (FileWriter writer = new FileWriter(file)){
            for(OrderReport result : reportList){
                writer.write(result.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
