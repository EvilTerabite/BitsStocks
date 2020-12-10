package me.evilterabite.bitsstocks.stockutils;

public class Stock {
    private String name;
    private String symbol;
    private boolean frozen = false;
    private double openingPrice;
    private double volatility;
    private double shares;

    public Stock(String name, String symbol, double openingPrice, double closingPrice, double volatility, double shares) {
        this.name = name;
        this.symbol = symbol;
        this.openingPrice = openingPrice;
        this.volatility = volatility;
        this.shares = shares;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getShares() {
        return shares;
    }
}
