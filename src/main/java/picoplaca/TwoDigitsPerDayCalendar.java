package picoplaca;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TwoDigitsPerDayCalendar implements Calendar {

    private final Map<DayOfWeek, int[]> calendar = new HashMap<>();

    public TwoDigitsPerDayCalendar(){
        calendar.put(DayOfWeek.MONDAY, new int[]{1, 2});
        calendar.put(DayOfWeek.TUESDAY, new int[]{3, 4});
        calendar.put(DayOfWeek.WEDNESDAY, new int[]{5, 6});
        calendar.put(DayOfWeek.THURSDAY, new int[]{7, 8});
        calendar.put(DayOfWeek.FRIDAY, new int[]{9, 0});
    }

    public boolean isDay(LocalDate localDate, int lastDigitPlate){
        return !isVacation(localDate) && isDigitDay(localDate,lastDigitPlate);
    }

    private boolean isDigitDay(LocalDate localDate, int lastDigitPlate) {
        int[] digitsDay = getDayDigits(localDate);
        for (int aDigitsDay : digitsDay) {
            if (aDigitsDay == lastDigitPlate) {
                return true;
            }
        }
        return false;
    }

    private int[] getDayDigits(LocalDate localDate) {
        return calendar.get(localDate.getDayOfWeek());
    }

    private boolean isVacation(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY));
    }
}
