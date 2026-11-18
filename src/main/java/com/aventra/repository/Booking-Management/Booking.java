package com.aventra.model;

import java.time.LocalDate;

public class Booking {
    private int bookingId, customerId, packageId, guests;
    private Integer guideId;
    private LocalDate travelDate;
    private String status;

    public Booking(int id,int customerId,int packageId,Integer guideId,int guests,LocalDate travelDate,String status){
        this.bookingId=id; this.customerId=customerId; this.packageId=packageId;
        this.guideId=guideId; this.guests=guests; this.travelDate=travelDate; this.status=status;
    }
    public int getBookingId(){return bookingId;}
    public int getCustomerId(){return customerId;}
    public int getPackageId(){return packageId;}
    public Integer getGuideId(){return guideId;}
    public int getGuests(){return guests;}
    public LocalDate getTravelDate(){return travelDate;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}
