package com.exchange.stock.web;

import com.exchange.stock.entity.Stock;
import com.exchange.stock.exceptions.StockException;
import com.exchange.stock.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService){
        this.stockService=stockService;
    }

    @GetMapping("/{order_id}")
     ResponseEntity<Stock> getStockByOrderId(@PathVariable(name = "order_id") int order_id){
        Stock theStock = stockService.findByOrderId(order_id);
        if(theStock==null){
            throw new StockException("Found Empty Stock Object");
        }
        return new ResponseEntity<>(theStock, HttpStatus.OK);
    }

    @GetMapping("/stocks")
     ResponseEntity<List<Stock>> getStocks(){
        List<Stock> returnStocks = stockService.findAll();
        return new ResponseEntity(returnStocks, HttpStatus.OK);
    }

    @PostMapping
     ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        stock.setOrder_id(0);
        Stock theStock = stockService.saveStock(stock);
        return new ResponseEntity(stock, HttpStatus.CREATED);
    }

    @PutMapping
     ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
        //Notify rule when stock value goes up or down
        //Pseudo Code//
        //Case 1:
        //Check in Request body Stock object that have price value or not.
        //If yes then
        //Case 2:
        //Get Price for that order_id from Database and compare with price available in Request Body Stock object
        //If value is not equals to previous one the push a notification.
        //With in response or in Headers or use a custom method.

        Stock theStock = stockService.saveStock(stock);
        return new ResponseEntity(stock, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{order_id}")
     ResponseEntity deleteStock(@PathVariable(name = "order_id") int order_id){
        if(order_id < 0){
            throw new StockException("No order_id found : " + order_id);
        }
         stockService.deleteStock(order_id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Deleted order Id", String.valueOf(order_id));
        return new ResponseEntity(headers,HttpStatus.OK);
    }
}
