package com.mockito.gettingstarted;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


class Stock {
    int id;
    String name;
    int quantity;

    public Stock(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}

interface StockService {

    public double getStockPrice(Stock stock);
}

class Portfolio {
    List<Stock> stockList;
    StockService stockservice;

    public Portfolio(StockService stockservice) {
        this.stockservice = stockservice;
        stockList = new ArrayList<>();
    }

    public void addStockToPortfolio(Stock stock) {
        stockList.add(stock);
    }

    public double getMarketValueOfPortfolio() {
        double mktvalue = 0;
        for (Stock stock : stockList) {
            mktvalue += stock.getQuantity() * stockservice.getStockPrice(stock);
        }
        return mktvalue;
    }

}

public class PortfolioTest {


    @Before
    public void setup() {

    }

    @Test
    public void testGetMarketValueOfPortfolioMethod() {

        StockService mockStockService = Mockito.mock(StockService.class);
        Portfolio portfolio = new Portfolio(mockStockService);

        Stock stock1 = new Stock(1, "abc", 10);
        Stock stock2 = new Stock(1, "xyz", 20);
        portfolio.addStockToPortfolio(stock1);
        portfolio.addStockToPortfolio(stock2);

        Mockito.when(mockStockService.getStockPrice(stock1)).thenReturn(20.00);
        Mockito.when(mockStockService.getStockPrice(stock2)).thenReturn(30.00);

        Assert.assertEquals(800.00, portfolio.getMarketValueOfPortfolio(), .00);

    }
}

class PortfolioTestRunner {
    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(PortfolioTest.class);
        System.out.println(res.wasSuccessful());
        System.out.println(res.getRunCount());
    }

}