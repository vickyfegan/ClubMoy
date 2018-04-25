package com.example.declan.clubmoy.Booking;

//https://www.youtube.com/watch?v=aCDgP2By1J0

public class SaveData {
    String fName, fDate, fTime, facOptions;

    public SaveData(String fName, String fDate, String fTime, String facOptions) {
        this.fName = fName;
        this.fDate = fDate;
        this.fTime = fTime;
        this.facOptions = facOptions;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfDate() {
        return fDate;
    }

    public void setfDate(String fDate) {
        this.fDate = fDate;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public String getFacOptions() {
        return facOptions;
    }

    public void setFacOptions(String facOptions) {
        this.facOptions = facOptions;
    }

}
