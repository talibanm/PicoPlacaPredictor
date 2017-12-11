package picoplaca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlateValidator implements Validator {
    @Override
    public boolean validate(String plate) throws Exception {
        String plateRegEx = "\\p{Alpha}{3}-\\d{3,4}";
        Pattern pattern = Pattern.compile(plateRegEx);
        Matcher matcher = pattern.matcher(plate);
        if (!matcher.matches()){
            throw new PicoPlacaException("Invalid plate number");
        }
        return true;
    }
}
