package com.omninous.Models;

public class TripModel {

    String date;
    String prices;
    String car_Name;
    String payment;

    public TripModel(String date, String prices, String car_Name, String payment) {
        this.date = date;
        this.prices = prices;
        this.car_Name = car_Name;
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public String getPrices() {
        return prices;
    }

    public String getCar_Name() {
        return car_Name;
    }

    public String getPayment() {
        return payment;
    }
}
