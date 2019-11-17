package com.example.Models;

public class BookingModel {

    String date;
    String booking_no;
    String location;

    public BookingModel(String date, String booking_no, String location) {
        this.date = date;
        this.booking_no = booking_no;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getBooking_no() {
        return booking_no;
    }

    public String getLocation() {
        return location;
    }
}
