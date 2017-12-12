package picoplaca;

import java.time.LocalDate;

public interface Calendar {
    boolean isDay(LocalDate localDate, int lastDigitPlate);
}
