package org.interview;

import org.interview.service.DoctorAppointmentService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        DoctorAppointmentService appointmentService = new DoctorAppointmentService();
        Scanner scanner = new Scanner(System.in);


        while(true){
            String input = scanner.next();

            if("registerDoc".equals(input)){
                try {
                    appointmentService.registDoctor(scanner.next(), scanner.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if("markDocAvail".equals(input)){
                try {
                    appointmentService.markDocAvailable(scanner.next(), scanner.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if("showAvailByspeciality".equals(input)){
                try {
                    appointmentService.showAvailByspeciality(scanner.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if("bookAppointment".equals(input)){
                try {
                    appointmentService.bookAppointMent(scanner.next(), scanner.next(), scanner.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if("cancelBooking".equals(input)){
                try {
                    appointmentService.cancelBooking(scanner.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
