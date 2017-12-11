package picoplaca;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PlateValidatorTest {

    @Test
    public void validPlate() throws Exception {
        String plate = "PQW-3244";
        Validator plateValidator = new PlateValidator();

        assertTrue("valid plate", plateValidator.validate(plate));
    }

    @Test(expected = PicoPlacaException.class)
    public void invalidPlate() throws Exception {
        String plate = "113-WWW";
        Validator plateValidator = new PlateValidator();

        plateValidator.validate(plate);
    }
}
