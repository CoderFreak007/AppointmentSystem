package org.interview.service;

import org.interview.model.*;

public class DoctorFactory {

    public static Doctor getDoctorBySpeciality(String speciality, String name) throws Exception {

        Speciality specialityNmame = Speciality.getSpecilaity(speciality);

        switch (specialityNmame){
            case Cardiologist:
              return new Cardiologist(name);
            case Dermatologist:
                return new Dermatologist(name);
            case Orthopedic:
                return new Orthopedic(name);
            case GeneralPhysician:
                return new GeneralPhysician(name);
        }

        throw new Exception("not a valid speciality");

    }
}
