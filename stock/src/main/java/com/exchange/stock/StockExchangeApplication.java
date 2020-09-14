package com.exchange.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StockExchangeApplication {

	public static void main(String[] args) {

	Map<String, String> m = new HashMap<>();
	m.put("a","a");
		SpringApplication.run(StockExchangeApplication.class, args);
	}

}
