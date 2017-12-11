package picoplaca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator implements Validator {
    @Override
    public boolean validate(String date) {
        String datePattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        LocalDate.parse(date, formatter);
        return true;
    }
}
