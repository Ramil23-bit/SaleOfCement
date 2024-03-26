package com.example.sale.service;

import com.example.sale.entity.OrderReport;
import com.example.sale.exception.OrderServiceException;

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
        if(fileName == null){
            throw new OrderServiceException("Имя файла NULL");
        }
        File file = new File(pathToFile + fileName);
        return Files.readAllLines(Paths.get(file.toURI()));
    }

    public void write(List<OrderReport> reportList, String fileName){
        File file = new File(pathToFile + fileName);
        if(fileName == null && reportList == null){
            throw new IllegalArgumentException("Имя файла NULL");
        }
        try (FileWriter writerFile = new FileWriter(file)){
            for(OrderReport result : reportList){
                writerFile.write(result.toString());
            }
        }catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
