package picoplaca;

import org.junit.Test;

import java.time.format.DateTimeParseException;

import static junit.framework.TestCase.assertTrue;

public class TimeValidatorTest {

    @Test
    public void validTime() throws Exception {
        String time = "02:00 PM";
        Validator timeValidator = new TimeValidator();

        assertTrue("valid time", timeValidator.validate(time));
    }

    @Test(expected = DateTimeParseException.class)
    public void InvalidTimeThrowsException() throws Exception {
        String date = "14:00 PM";
        Validator timeValidator = new TimeValidator();

        timeValidator.validate(date);
    }
}
