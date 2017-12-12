import picoplaca.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    private static Validator dateValidator = new DateValidator();
    private static Validator timeValidator = new TimeValidator();
    private static Validator plateValidator = new PlateValidator();
    private static String plate;
    private static LocalDate localDate;
    private static LocalTime localTime;
    private static Calendar calendar = new TwoDigitsPerDayCalendar();
    private static Schedule schedule = new MorningAndAfternoonSchedule();

    public static void main(String[] args){
        validateArgs(args);
        validatePicoPlaca(args);
    }

    private static void validatePicoPlaca(String[] args) {
        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        setValues(args);
        if (picoPlaca.predict(plate, localDate, localTime)) {
            System.out.print("¡¡¡ TIENES PICO Y PLACA. NO CIRCULAR !!!");
        } else {
            System.out.print("NO TIENES PICO Y PLACA. BUEN VIAJE");
        }
    }

    private static void setValues(String[] args) {
        plate = args[0];
        if(args.length > 1) {
            localDate = ((DateValidator) dateValidator).parse(args[1]);
            localTime = ((TimeValidator) timeValidator).parse(args[2]);
        } else{
            localDate = LocalDate.now();
            localTime = LocalTime.now();
        }
    }

    private static void validateArgs(String[] args){
        InputArgsValidator inputArgsValidator = new InputArgsValidator(plateValidator, dateValidator, timeValidator);
        try {
            inputArgsValidator.validate(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
