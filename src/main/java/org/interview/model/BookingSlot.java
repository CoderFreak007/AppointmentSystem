package org.interview.model;

import java.util.UUID;

public class BookingSlot {

    public String getBookingId() {
        return bookingId;
    }

    private String bookingId;

    private String startTime;

    private String endTime;

    private boolean slotAvailable;

    public String getPatient() {
        return patient;
    }

    private String patient;


    public BookingSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean isSlotAvailable() {
        return patient == null;
    }

    public String getSlotName(){
        return startTime+"-"+endTime;
    }

    public String bookdSlot(String pateint){
        this.bookingId = UUID.randomUUID().toString();
        this.patient = pateint;
        return bookingId;
    }




}
