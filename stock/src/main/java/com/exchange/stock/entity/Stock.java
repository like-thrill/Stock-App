package com.exchange.stock.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="stock")
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "stockname")
    private String stockname;
    @Column(name = "type")
    private String type;
    @Min(value = 1)
    @Column(name = "quantity")
    private int quantity;
    @Min(value = 1)
    @Column(name = "price")
    private int price;
    @Column(name = "time")
    private String time;

    public Stock(){

    }
    public Stock(int order_id, String stockname, String type, int quantity, int price, String time) {
        this.order_id = order_id;
        this.stockname = stockname;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.time = time;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
