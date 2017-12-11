package picoplaca;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeValidator implements Validator {
    @Override
    public boolean validate(String time) {
        String timePattern = "hh:mm a";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timePattern);
        LocalTime.parse(time,formatter);
        return true;
    }
}
