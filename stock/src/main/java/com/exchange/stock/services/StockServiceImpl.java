package com.exchange.stock.services;

import com.exchange.stock.entity.Stock;
import com.exchange.stock.entity.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    private StockDAO stockDAO;

    @Autowired
    public StockServiceImpl(StockDAO stockDAO){
        this.stockDAO=stockDAO;
    }

    @Override
    @Transactional
    public List<Stock> findAll() {
        return stockDAO.findAll();
    }

    @Override
    @Transactional
    public Stock saveStock(Stock stock) {
        return stockDAO.saveStock(stock);
    }


    @Override
    @Transactional
    public void deleteStock(int id) {
        stockDAO.deleteStock(id);
    }

    @Override
    public Stock findByOrderId(int order_id) {
        return stockDAO.findByOrderId(order_id);
    }
}
