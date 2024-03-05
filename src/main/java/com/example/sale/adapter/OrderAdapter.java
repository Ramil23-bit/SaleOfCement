package com.example.sale.adapter;

import com.example.sale.entity.Order;

import java.util.List;

public interface OrderAdapter {
   List<Order> toOrders(List<String> listString);
}
