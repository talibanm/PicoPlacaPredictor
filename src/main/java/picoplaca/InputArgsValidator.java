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

    public boolean validate(String[] args) throws Exception {
        validateArgsNumber(args);
        plateValidator.validate(args[0]);
        if (args.length > 1) {
            dateValidator.validate(args[1]);
            timeValidator.validate(args[2]);
        }
        return false;
    }

    public boolean validateArgsNumber(String[] args) throws Exception {
        if (args.length != 1 && args.length != 3) {
            throw new PicoPlacaException("Invalid args number");
        }
        return true;
    }
}
