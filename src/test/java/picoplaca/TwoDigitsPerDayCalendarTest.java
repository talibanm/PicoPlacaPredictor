package picoplaca;

import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;

public class TwoDigitsPerDayCalendarTest {
    @Test
    public void isDay(){
        TwoDigitsPerDayCalendar calendar = new TwoDigitsPerDayCalendar();
        LocalDate localDate = LocalDate.of(2017,12,11);
        assertTrue("Monday first digit",calendar.isDay(localDate,1));
        assertTrue("Monday second digit",calendar.isDay(localDate,2));
    }

    @Test
    public void notIsDay(){
        TwoDigitsPerDayCalendar calendar = new TwoDigitsPerDayCalendar();
        LocalDate localDate = LocalDate.of(2017,12,11);
        assertTrue("Monday first digit",!calendar.isDay(localDate,3));
        assertTrue("Monday second digit",!calendar.isDay(localDate,4));
    }

    @Test
    public void notIsDayVacation(){
        TwoDigitsPerDayCalendar calendar = new TwoDigitsPerDayCalendar();
        LocalDate localDate = LocalDate.of(2017,12,10);
        assertTrue("Sunday first digit",!calendar.isDay(localDate,0));
    }
}
