package com.example.quantsapptest;

public class Symbol {

    private String symbolName;
    private  double price;
    private double open_interest;
    private double price_change;
    private double open_interest_change;

    public Symbol(String symbolName, double price, double open_interest, double price_change, double open_interest_change) {
        this.symbolName = symbolName;
        this.price = price;
        this.open_interest = open_interest;
        this.price_change = price_change;
        this.open_interest_change = open_interest_change;
    }

    public Symbol() {

    }

    public String getSymbolName() {
        return symbolName;
    }

    public double getPrice() {
        return price;
    }

    public double getOpen_interest() {
        return open_interest;
    }

    public double getPrice_change() {
        return price_change;
    }

    public double get_Open_interest_change() {
        return open_interest_change;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOpen_interest(double open_interest) {
        this.open_interest = open_interest;
    }

    public void setPrice_change(double price_change) {
        this.price_change = price_change;
    }

    public void setOpen_interest_change(double open_interest_change) {
        this.open_interest_change = open_interest_change;
    }
}
