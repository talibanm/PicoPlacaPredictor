package picoplaca;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class PicoPlaca {
    private final List<LocalTime[]> schedule = new ArrayList<>();
    private final Map<DayOfWeek, int[]> calendar = new HashMap<>();

    public PicoPlaca(){
        createCalendar();
        createSchedule();
    }

    private void createCalendar() {
        calendar.put(DayOfWeek.MONDAY, new int[]{1, 2});
        calendar.put(DayOfWeek.TUESDAY, new int[]{3, 4});
        calendar.put(DayOfWeek.WEDNESDAY, new int[]{5, 6});
        calendar.put(DayOfWeek.THURSDAY, new int[]{7, 8});
        calendar.put(DayOfWeek.FRIDAY, new int[]{9, 0});
    }

    private void createSchedule() {
        schedule.add(new LocalTime[]{LocalTime.of(7,0),LocalTime.of(9,30)});
        schedule.add(new LocalTime[]{LocalTime.of(16,0),LocalTime.of(19,30)});
    }

    public boolean predict(String plate, LocalDate localDate, LocalTime localTime) {
        return !isVacation(localDate) && isPicoPlacaDay(plate, localDate) && isPicoPlacaTime(localTime);
    }

    private boolean isPicoPlacaTime(LocalTime localTime) {
        Iterator<LocalTime[]> iterator = schedule.iterator();
        LocalTime[] range;

        while(iterator.hasNext()){
            range = iterator.next();
            if(localTime.compareTo(range[0]) >= 0 && localTime.compareTo(range[1]) <= 0){
                return true;
            }
        }
        return false;
    }

    private boolean isPicoPlacaDay(String plate, LocalDate localDate) {
        int lastDigitPlate = obtainLastDigitPlate(plate);
        int[] digitsDay = obtainDigitsDay(localDate);
        for (int aDigitsDay : digitsDay) {
            if (aDigitsDay == lastDigitPlate) {
                return true;
            }
        }
        return false;
    }

    private boolean isVacation(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY));
    }

    private int[] obtainDigitsDay(LocalDate localDate) {
        return calendar.get(localDate.getDayOfWeek());
    }

    private int obtainLastDigitPlate(String plate) {
        return Integer.parseInt(String.valueOf(plate.charAt(plate.length() - 1)));
    }
}
