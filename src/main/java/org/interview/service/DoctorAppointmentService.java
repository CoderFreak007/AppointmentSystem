package org.interview.service;

import org.interview.model.BookingSlot;
import org.interview.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorAppointmentService {

    private SlotService slotService = new SlotService();

    private DoctorFactory doctorFactory = new DoctorFactory();

    private List<Doctor> registeredDoctors = new ArrayList<>();


    public void registDoctor(String name, String speciality) throws Exception {
        Doctor newdoctor = doctorFactory.getDoctorBySpeciality(speciality, name);
        registeredDoctors.add(newdoctor);
        System.out.println("Welcome Dr."+newdoctor.getName());
    }

    public void markDocAvailable(String name, String slot) throws Exception {


        if(!slotService.validateSlot(slot)){
            System.out.println("Sorry Dr. Curious slots are 30 mins only");
            return;
        }

        Doctor doctor = getDoctorByName(name);
        BookingSlot bookingSlot = slotService.getBookingSlot(slot);
        doctor.addSlot(bookingSlot);
        System.out.println("Done Doc");



    }

    private Doctor getDoctorByName(String name) throws Exception {
        for(Doctor doctor : registeredDoctors){
            if(doctor.getName().equalsIgnoreCase(name))
                return doctor;
        }
       throw new Exception("No doctor avaible By name"+name);
    }

    public void bookAppointMent(String pateint, String doctorName, String slotStartTime) throws Exception {

        if(!slotService.canPateintBookSlot(registeredDoctors, slotStartTime)){
            throw new Exception("you can book more that one slot for same slot");
        }

        Doctor doctor = getDoctorByName(doctorName);
        BookingSlot bookingSlot =  slotService.getDoctorSlotByStartTime(doctor, slotStartTime);
        if(bookingSlot == null)
            throw new Exception("doctor is not available in this slot");
        if(!bookingSlot.isSlotAvailable())
            throw new Exception("slot is alrady booked");
        String bookingId = bookingSlot.bookdSlot(pateint);
        System.out.println("Booked: booking id"+bookingId);

    }

    public void showAvailByspeciality(String speciality) throws Exception {

        for(Doctor doctor : registeredDoctors){
            if(doctor.getClass().equals(DoctorFactory.getDoctorBySpeciality(speciality, "").getClass()))
              for(BookingSlot bookingSlot : doctor.getDoctorsSlot()){
                  if(bookingSlot.isSlotAvailable()){
                      System.out.println(doctor.getPrefixName()+":"+bookingSlot.getSlotName());
                  }
              }
        }

    }

    public void cancelBooking(String bookingId){

        for(Doctor doctor : registeredDoctors){
            for(BookingSlot bookingSlot : doctor.getDoctorsSlot()){
                if(bookingId.equals(bookingSlot.getBookingId())){
                    System.out.println("Booking cancelled");
                }
            }
        }

    }

    public void getDoctorSummary(String doctorname) throws Exception {

        Doctor doctor = getDoctorByName(doctorname);
            for(BookingSlot bookingSlot : doctor.getDoctorsSlot()){
               System.out.println("Doctor "+doctor.getPrefixName()+" slot "+bookingSlot.getSlotName()+"" +
                       " isvailable "+ bookingSlot.isSlotAvailable());

        }

    }

    public void getpateintSummary(String pateint) throws Exception {

        for(Doctor doctor : registeredDoctors){
        for(BookingSlot bookingSlot : doctor.getDoctorsSlot()) {
            if(pateint.equals(bookingSlot.getPatient())) {
                System.out.println("Doctor " + doctor.getPrefixName() + " slot " + bookingSlot.getSlotName() + "" +
                        " isvailable " + bookingSlot.isSlotAvailable());
            }


        }}

    }








}
