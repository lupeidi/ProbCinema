package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientValidator {
    public void validate(Client client) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(client.getBirthdayDate());
        } catch (ParseException pe) {
            throw new RuntimeException("Birthday date is not in a correct format!");
        }

        try {
            format.parse(client.getRegistrationDate());
        } catch (ParseException pe) {
            throw new RuntimeException("Registration date is not in a correct format!");
        }

        if (client.getCnp().length() != 13) {
            throw new RuntimeException("Client CNP is not valid!");
        }
    }
}
