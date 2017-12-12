package picoplaca;

import java.time.LocalDate;
import java.time.LocalTime;

public class PicoPlaca {

    private final Calendar calendar;
    private final Schedule schedule;

    public PicoPlaca(Calendar calendar, Schedule schedule){
        this.calendar = calendar;
        this.schedule = schedule;
    }

    public boolean predict(String plate, LocalDate localDate, LocalTime localTime) {
        return isPicoPlacaDay(plate, localDate) && isPicoPlacaTime(localTime);
    }

    private boolean isPicoPlacaTime(LocalTime localTime) {
        return schedule.isTime(localTime);
    }

    private boolean isPicoPlacaDay(String plate, LocalDate localDate) {
        return calendar.isDay(localDate, obtainLastDigitPlate(plate));
    }

    private int obtainLastDigitPlate(String plate) {
        return Integer.parseInt(String.valueOf(plate.charAt(plate.length() - 1)));
    }
}
