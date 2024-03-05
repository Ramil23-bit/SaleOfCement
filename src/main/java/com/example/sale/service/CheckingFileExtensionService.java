package com.example.sale.service;

import com.example.sale.adapter.FileOrderAdapter;
import com.example.sale.adapter.FileWithoutExtensionAdapter;
import com.example.sale.adapter.OrderAdapter;

public class CheckingFileExtensionService {

    public OrderAdapter checkingFile(String fileName){
        int index = fileName.indexOf('.');
        return index == -1 ? new FileWithoutExtensionAdapter() : new FileOrderAdapter();
    }
}
