package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReservationValidator implements IValidator<Reservation> {

    public void validate(Reservation reservation) {
        if (reservation.getDate().getYear() > (Calendar.getInstance().get(Calendar.YEAR) + 1) ){
            throw new RuntimeException("Reservation year is not allowed yet");
        }
        else if (reservation.getDate().getYear() < Calendar.getInstance().get(Calendar.YEAR) ){
            throw new RuntimeException("Reservation year must not be in the past");
        }
    }
}
