package picoplaca;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MorningAndAfternoonSchedule implements Schedule {
    private final List<LocalTime[]> schedule = new ArrayList<>();

    public MorningAndAfternoonSchedule(){
        schedule.add(new LocalTime[]{LocalTime.of(7,0),LocalTime.of(9,30)});
        schedule.add(new LocalTime[]{LocalTime.of(16,0),LocalTime.of(19,30)});
    }

    public boolean isTime(LocalTime localTime) {
        for(LocalTime[] aLocalTime : schedule){
            if(localTime.compareTo(aLocalTime[0]) >= 0 && localTime.compareTo(aLocalTime[1]) <= 0){
                return true;
            }
        }
        return false;
    }
}
