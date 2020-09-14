package com.exchange.stock.services;

import com.exchange.stock.entity.Stock;

import java.util.List;

public interface StockService {


    public List<Stock> findAll();

    public Stock saveStock(Stock stock);

    public void deleteStock(int id);

    Stock findByOrderId(int order_id);
}
