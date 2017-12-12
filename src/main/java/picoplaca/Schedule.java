package picoplaca;

import java.time.LocalTime;

public interface Schedule {
    boolean isTime(LocalTime localTime);
}
