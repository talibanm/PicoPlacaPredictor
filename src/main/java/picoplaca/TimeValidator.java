package picoplaca;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeValidator implements Validator {
    private static String timePattern = "hh:mm a";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timePattern);
    @Override
    public boolean validate(String time) {
        parse(time);
        return true;
    }

    public LocalTime parse(String time) {
        return LocalTime.parse(time,formatter);
    }
}
