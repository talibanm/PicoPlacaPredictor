package picoplaca;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class InputArgsValidatorTest {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();
    private final Validator validator = context.mock(Validator.class);

    @Test
    public void argsNumberCanBeOne() throws Exception {
        String[] oneArg = new String[]{"AAA-111"};
        InputArgsValidator inputArgsValidator = new InputArgsValidator(null,null,null);

        assertTrue("one arg", inputArgsValidator.validateNumberOfArgs(oneArg));
    }

    @Test
    public void argsNumberCanBeThree() throws Exception {
        String[] threeArgs = new String[]{"AAA-111","2017-12-11","11:46 AM"};
        InputArgsValidator inputArgsValidator = new InputArgsValidator(null,null,null);

        assertTrue("three args", inputArgsValidator.validateNumberOfArgs(threeArgs));
    }

    @Test(expected = PicoPlacaException.class)
    public void argsNumberCanNotBeTwo() throws Exception {
        String[] threeArgs = new String[]{"AAA-111","2017-12-11"};
        InputArgsValidator inputArgsValidator = new InputArgsValidator(null,null,null);

        assertTrue("two args",!inputArgsValidator.validateNumberOfArgs(threeArgs));
    }

    @Test(expected = PicoPlacaException.class)
    public void argsNumberCanNotBeCero() throws Exception {
        String[] threeArgs = new String[]{};
        InputArgsValidator inputArgsValidator = new InputArgsValidator(null,null,null);

        assertTrue("cero args",!inputArgsValidator.validateNumberOfArgs(threeArgs));
    }

    @Test
    public void validatePlate() throws Exception {
        String[] args = new String[]{"AAA-111"};
        context.checking(new Expectations(){{
            oneOf(validator).validate(args[0]);
        }});
        InputArgsValidator inputArgsValidator = new InputArgsValidator(validator, null, null);
        inputArgsValidator.validate(args);
    }

    @Test
    public void validateDate() throws Exception {
        String[] args = new String[]{"AAA-111","2017-12-11","04:49 PM"};
        context.checking(new Expectations(){{
            ignoring(validator).validate(args[0]);
            oneOf(validator).validate(args[1]);
            ignoring(validator).validate(args[2]);
        }});
        InputArgsValidator inputArgsValidator = new InputArgsValidator(validator, validator, validator);
        inputArgsValidator.validate(args);
    }

    @Test
    public void validateTime() throws Exception {
        String[] args = new String[]{"AAA-111","2017-12-11","04:49 PM"};
        context.checking(new Expectations(){{
            ignoring(validator).validate(args[0]);
            ignoring(validator).validate(args[1]);
            oneOf(validator).validate(args[2]);
        }});
        InputArgsValidator inputArgsValidator = new InputArgsValidator(validator, validator, validator);
        inputArgsValidator.validate(args);
    }
}
