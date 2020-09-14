package com.exchange.stock.entity;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class StockDAOImpl implements StockDAO {

    private EntityManager entityManager;

    @Autowired
    public StockDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Stock> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("from Stock");
        List<Stock> theStocks = theQuery.getResultList();
        return theStocks;
    }

    @Override
    public Stock saveStock(Stock stock) {
        entityManager.merge(stock);
        return stock;
    }

    @Override
    public void deleteStock(int id) {

        Query theQuery = entityManager.createQuery("delete from Stock where order_id=:orderId");
        theQuery.setParameter("orderId", id);
        theQuery.executeUpdate();
    }

    @Override
    public Stock findByOrderId(int order_id) {
        Stock theStock = entityManager.find(Stock.class,order_id);
        return theStock;
    }

}
