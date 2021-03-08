package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] Args) throws ParseException {
        Scanner cs = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        sysout("Room number: ");
        int number = cs.nextInt();
        sysout("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(cs.next());
        sysout("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(cs.next());

        if (!checkOut.after(checkIn)) {
            sysout("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            sysout("");
            sysout("Enter data to update the reservation:");
            sysout("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(cs.next());
            sysout("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(cs.next());


            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                sysout("Error in reservation: " + error);
            } else {
                System.out.println("Reservation: " + reservation);
            }
        }

        cs.close();
    }

    public static void sysout(String frase){
        System.out.println(frase);
    }
}
