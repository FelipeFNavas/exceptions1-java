package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer rommNumber;
    private Date checkIn;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){}

    public Reservation(Integer rommNumber, Date checkIn, Date checkout) {
        this.rommNumber = rommNumber;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public Integer getRommNumber() {
        return rommNumber;
    }

    public void setRommNumber(Integer rommNumber) {
        this.rommNumber = rommNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkout){
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        return "Room "
                + rommNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
    }

}
