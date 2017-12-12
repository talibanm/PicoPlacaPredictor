package picoplaca;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UtilsTest {
    @Test
    public void validateDate(){
        String date = "2017-12-11";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date,formatter);

        assertEquals("year",2017,localDate.getYear());
        assertEquals("month",12,localDate.getMonthValue());
        assertEquals("day",11,localDate.getDayOfMonth());
        assertEquals("day of week",DayOfWeek.MONDAY,localDate.getDayOfWeek());
    }

    @Test
    public void validateTime(){
        String time = "12:00 PM";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime localTime = LocalTime.parse(time,formatter);

        assertEquals("hour",12,localTime.getHour());
        assertEquals("minute",0,localTime.getMinute());
    }

    @Test
    public void validatePlate(){
        String plate1 = "PBA-011";
        String plate2 = "PBA-0112";

        Pattern pattern = Pattern.compile("\\p{Alpha}{3}-\\d{3,4}");

        Matcher matcher = pattern.matcher(plate1);
        assertTrue("short old plate",matcher.matches());

        matcher = pattern.matcher(plate2);
        assertTrue("large new plate",matcher.matches());
    }

    @Test
    public void getPicoPlacaCalendar(){
        Map<DayOfWeek, int[]> calendar = new HashMap<>();
        calendar.put(DayOfWeek.MONDAY, new int[]{1, 2});
        calendar.put(DayOfWeek.TUESDAY, new int[]{3, 4});
        calendar.put(DayOfWeek.WEDNESDAY, new int[]{5, 6});
        calendar.put(DayOfWeek.THURSDAY, new int[]{7, 8});
        calendar.put(DayOfWeek.FRIDAY, new int[]{9, 0});

        int[] last = calendar.get(DayOfWeek.MONDAY);

        assertEquals("last number", 1, last[0]);
        assertEquals("last number", 2, last[1]);

        last = calendar.get(DayOfWeek.SATURDAY);

        assertNull(last);
    }

    @Test
    public void setRestrictionSchedule(){
        List<LocalTime[]> schedule = new ArrayList<>();
        schedule.add(new LocalTime[]{LocalTime.of(7,0),LocalTime.of(9,30)});
        schedule.add(new LocalTime[]{LocalTime.of(16,0),LocalTime.of(19,30)});

        LocalTime localTime = LocalTime.of(16,55);

        Iterator<LocalTime[]> iterator = schedule.iterator();

        LocalTime[] morning = iterator.next();
        assertTrue("morning",!(localTime.compareTo(morning[0]) >= 0 && localTime.compareTo(morning[1]) <= 0));

        LocalTime[] afternoon = iterator.next();
        assertTrue("afternoon",(localTime.compareTo(afternoon[0]) >= 0 && localTime.compareTo(afternoon[1]) <= 0));

    }

    @Test
    public void obtainLastDigit(){
        String plate = "AQA-1564";
        int lastDigit = Integer.parseInt(String.valueOf(plate.charAt(plate.length() - 1)));

        assertEquals("lastDigit",4,lastDigit);
    }
}
