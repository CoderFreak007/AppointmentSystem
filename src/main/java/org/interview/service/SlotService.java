package org.interview.service;

import org.interview.model.BookingSlot;
import org.interview.model.Doctor;

import java.util.List;

public class SlotService {


    public BookingSlot getBookingSlot(String slot){

        String[] spliltSlot = slot.split("-");
        String startTime = spliltSlot[0];
        String endTime = spliltSlot[1];

        return new BookingSlot(startTime, endTime);


    }

    public BookingSlot getDoctorSlotByStartTime(Doctor doctor, String startTime){

        for(BookingSlot slot : doctor.getDoctorsSlot()){
            if(slot.getStartTime().equalsIgnoreCase(startTime))
                return slot;
        }
        return null;

    }

    public boolean canPateintBookSlot(List<Doctor> doctors, String startTime) {

        for (Doctor doctor : doctors) {
            for (BookingSlot slot : doctor.getDoctorsSlot()) {
                if (!slot.isSlotAvailable() && slot.getStartTime().equalsIgnoreCase(startTime))
                    return false;
            }
        }
        return true;

    }

    public boolean validateSlot(String slot) throws Exception {
        try {
            String[] spliltSlot = slot.split("-");
            String startTime = spliltSlot[0];
            String endTime = spliltSlot[1];
            String[] startTimeSplit = startTime.split(":");
            String[] endTimeSplit = endTime.split(":");

            int startHour = Integer.parseInt(startTimeSplit[0]);
            int startMinute = Integer.parseInt(startTimeSplit[1]);

            int endHour = Integer.parseInt(endTimeSplit[0]);
            int endMinute = Integer.parseInt(endTimeSplit[1]);


            int totalMinutesInSlot = (endHour-startHour)*60+(endMinute-startMinute);

            if(totalMinutesInSlot != 30)
                return false;
        }catch (Exception ex){
            throw  new Exception("slot provided is not correct format");
        }

        return true;
    }


}
