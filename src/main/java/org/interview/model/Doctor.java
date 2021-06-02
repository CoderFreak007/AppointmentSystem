package org.interview.model;

import java.util.ArrayList;
import java.util.List;

public class  Doctor {

    private String name;

    private List<BookingSlot> doctorsSlot;


    public Doctor(String name) {
        this.name = name;
        doctorsSlot = new ArrayList<>();
    }

    public Doctor() {
        doctorsSlot = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<BookingSlot> getDoctorsSlot() {
        return doctorsSlot;
    }

    public void addSlot(BookingSlot slot){
        doctorsSlot.add(slot);
    }

    public String getPrefixName() {
        return "Dr."+name;
    }
}
