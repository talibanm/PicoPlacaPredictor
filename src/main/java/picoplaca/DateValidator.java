package picoplaca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator implements Validator {
    private final String datePattern = "yyyy-MM-dd";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);

    @Override
    public boolean validate(String date) {
        parse(date);
        return true;
    }
    public LocalDate parse(String date){
        return LocalDate.parse(date, formatter);
    }
}
