package com.example.sale.service;

import com.example.sale.adapter.FileOrderAdapter;
import com.example.sale.adapter.FileWithoutExtensionAdapter;
import com.example.sale.adapter.OrderAdapter;

public class CheckFileExtensionService {

    public OrderAdapter checkFile(String fileName){
        if(fileName == null || fileName.isEmpty()){
            throw new IllegalArgumentException("Параметр не может быть NULL");
        }
        int index = fileName.indexOf('.');
        return index == -1 ? new FileWithoutExtensionAdapter() : new FileOrderAdapter();
    }
}
