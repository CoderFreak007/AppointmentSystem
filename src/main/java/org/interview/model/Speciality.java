package org.interview.model;

public enum Speciality {

    Cardiologist("Cardiologist"), Dermatologist("Dermatologist"),
    Orthopedic("Orthopedic"), GeneralPhysician("General Physician");

    private String speciality;

    Speciality(String speciality) {
        this.speciality = speciality;
    }


    public static Speciality getSpecilaity(String specialityName){
        for(Speciality speciality : Speciality.values()){
            if(speciality.speciality.equals(specialityName))
                return speciality;
        }
        return null;
    }
}
