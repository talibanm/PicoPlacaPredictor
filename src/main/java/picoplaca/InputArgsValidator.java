package picoplaca;

public class InputArgsValidator {

    private final Validator plateValidator;
    private final Validator dateValidator;
    private final Validator timeValidator;

    public InputArgsValidator(Validator plateValidator, Validator dateValidator, Validator timeValidator) {
        this.plateValidator = plateValidator;
        this.dateValidator = dateValidator;
        this.timeValidator = timeValidator;
    }

    public void validate(String[] args) throws Exception {
        validateNumberOfArgs(args);
        validateArgs(args);
    }

    private void validateArgs(String[] args) throws Exception {
        String plate = args[0];
        plateValidator.validate(plate);
        if (args.length > 1) {
            String date = args[1];
            String time = args[2];
            dateValidator.validate(date);
            timeValidator.validate(time);
        }
    }

    public boolean validateNumberOfArgs(String[] args) throws Exception {
        if (args.length != 1 && args.length != 3) {
            throw new PicoPlacaException("Invalid number of args. Should be plate or plate date time");
        }
        return true;
    }
}
