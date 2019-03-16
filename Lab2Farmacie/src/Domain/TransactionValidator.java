package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransactionValidator {
    public void validate(Transaction transaction) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatHour = new SimpleDateFormat("hh.mm");
        try {
            format.parse(transaction.getDate());
        } catch (ParseException pe) {
            throw new RuntimeException("Date is not in a correct format!");
        }
        try {
            formatHour.parse(transaction.getHour());
        } catch (ParseException pe) {
            throw new RuntimeException("Hour is not in a correct format!");
        }
    }
}
