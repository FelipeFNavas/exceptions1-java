package application;

import model.entities.Reservation;
import model.excepctions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] Args){
        Scanner cs = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            sysout("Room number: ");
            int number = cs.nextInt();
            sysout("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(cs.next());
            sysout("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(cs.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            sysout("");
            sysout("Enter data to update the reservation:");
            sysout("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(cs.next());
            sysout("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(cs.next());


            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch(ParseException e){
            sysout("Invalid date format");
        }
        catch(DomainException e){
            sysout("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            sysout("Unexpected error");
        }


        cs.close();
    }

    public static void sysout(String frase){
        System.out.println(frase);
    }
}
