package com.example.declan.clubmoy;

public class Facility {

    String bookingId;
    String name;
    String facilitiesOptions;
    String facilitiesDate;
    String facilitiesTime;

    public Facility()
    {

    }

    public Facility(String bookingId, String name, String facilitiesOptions, String facilitiesDate, String facilitiesTime) {
        this.bookingId = bookingId;
        this.name = name;
        this.facilitiesOptions = facilitiesOptions;
        this.facilitiesDate = facilitiesDate;
        this.facilitiesTime = facilitiesTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getName() {
        return name;
    }

    public String getFacilitiesOptions() {
        return facilitiesOptions;
    }

    public String getFacilitiesDate() {
        return facilitiesDate;
    }

    public String getFacilitiesTime() {
        return facilitiesTime;
    }
}
