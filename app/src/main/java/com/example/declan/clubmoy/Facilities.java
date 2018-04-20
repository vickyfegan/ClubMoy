package com.example.declan.clubmoy;

public class Facilities {

    public String fName, fDate, fTime, facOptions;

    public Facilities()
    {

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

    public Facilities(String fName, String fDate, String fTime, String facOptions) {
        this.fName = fName;
        this.fDate = fDate;
        this.fTime = fTime;
        this.facOptions = facOptions;


    }
}
