package com.exchange.stock.entity;

import com.exchange.stock.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StockDAO {

    public List<Stock> findAll();

    public Stock saveStock(Stock stock);

    public void deleteStock(int id);

    Stock findByOrderId(int order_id);
}
