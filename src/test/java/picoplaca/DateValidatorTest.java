package picoplaca;

import org.junit.Test;

import java.time.format.DateTimeParseException;

import static junit.framework.TestCase.assertTrue;

public class DateValidatorTest {

    @Test
    public void validDate() throws Exception {
        String date = "2017-12-11";
        Validator dateValidator = new DateValidator();


        assertTrue("valid date", dateValidator.validate(date));
    }

    @Test(expected = DateTimeParseException.class)
    public void InvalidDateThrowsException() throws Exception {
        String date = "2017-13-13";
        Validator dateValidator = new DateValidator();

        dateValidator.validate(date);
    }
}
