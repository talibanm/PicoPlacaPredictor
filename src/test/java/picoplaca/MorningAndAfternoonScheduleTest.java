package picoplaca;

import org.junit.Test;

import java.time.LocalTime;

import static junit.framework.TestCase.assertTrue;

public class MorningAndAfternoonScheduleTest {
    @Test
    public void isTime(){
        MorningAndAfternoonSchedule schedule = new MorningAndAfternoonSchedule();
        LocalTime morningInitialLimit = LocalTime.of(7,0);
        LocalTime morningFinalLimit = LocalTime.of(9,30);
        LocalTime afternoonInitialLimit = LocalTime.of(16,0);
        LocalTime afternoonFinalLimit = LocalTime.of(19,30);

        assertTrue("Morning initial limit", schedule.isTime(morningInitialLimit));
        assertTrue("Morning final limit", schedule.isTime(morningFinalLimit));
        assertTrue("Afternoon initial limit", schedule.isTime(afternoonInitialLimit));
        assertTrue("Afternoon final limit", schedule.isTime(afternoonFinalLimit));
    }

    @Test
    public void notIsTime(){
        MorningAndAfternoonSchedule schedule = new MorningAndAfternoonSchedule();
        LocalTime morningInitialLimit = LocalTime.of(6,59);
        LocalTime morningFinalLimit = LocalTime.of(9,31);
        LocalTime afternoonInitialLimit = LocalTime.of(15,59);
        LocalTime afternoonFinalLimit = LocalTime.of(19,31);

        assertTrue("Morning initial limit", !schedule.isTime(morningInitialLimit));
        assertTrue("Morning final limit", !schedule.isTime(morningFinalLimit));
        assertTrue("Afternoon initial limit", !schedule.isTime(afternoonInitialLimit));
        assertTrue("Afternoon final limit", !schedule.isTime(afternoonFinalLimit));
    }
}
