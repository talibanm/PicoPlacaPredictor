package picoplaca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator implements Validator {
    private DateTimeFormatter formatter;

    public DateValidator() {
        String datePattern = "yyyy-MM-dd";
        formatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public boolean validate(String date) {
        parse(date);
        return true;
    }
    public LocalDate parse(String date){
        return LocalDate.parse(date, formatter);
    }
}
