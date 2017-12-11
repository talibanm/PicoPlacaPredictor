import picoplaca.*;

public class Main {

    public static void main(String[] args){

        Validator plateValidator = new PlateValidator();
        Validator dateValidator = new DateValidator();
        Validator timeValidator = new TimeValidator();
        InputArgsValidator inputArgsValidator = new InputArgsValidator(plateValidator, dateValidator, timeValidator);
        try {
            inputArgsValidator.validate(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
