package picoplaca;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class PicoPlacaTest {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();
    private final Calendar calendar = context.mock(Calendar.class);
    private final Schedule schedule = context.mock(Schedule.class);

    @Test
    public void predictVacationPicoPlaca(){
        LocalDate localDate = LocalDate.of(2017,12,9);
        LocalTime localTime = LocalTime.of(12,10);
        String plate = "PBA-1516";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,6);
            will(returnValue(false));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("no pico-placa",false, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictMorningPicoPlacaInitialLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(7,0);
        String plate = "PBA-1511";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,1);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(true));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("pico-placa",true, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictMorningPicoPlacaFinalLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(9,30);
        String plate = "PBA-1511";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,1);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(true));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("pico-placa",true, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictAfternoonPicoPlacaInitialLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(16,0);
        String plate = "PBA-1511";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,1);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(true));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("pico-placa",true, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictAfternoonPicoPlacaFinalLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(19,30);
        String plate = "PBA-1511";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,1);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(true));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("pico-placa",true, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictNoMorningPicoPlacaInitialLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(6,59);
        String plate = "PBA-1510";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,0);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(false));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("no pico-placa",false, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictNoMorningPicoPlacaFinalLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(9,31);
        String plate = "PBA-1510";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,0);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(false));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("no pico-placa",false, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictNoAfternoonPicoPlacaInitialLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(15,59);
        String plate = "PBA-1510";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,0);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(false));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("no pico-placa",false, picoPlaca.predict(plate,localDate,localTime));
    }

    @Test
    public void predictNoAfternoonPicoPlacaFinalLimit(){
        LocalDate localDate = LocalDate.of(2017,12,11);
        LocalTime localTime = LocalTime.of(19,31);
        String plate = "PBA-1510";

        context.checking(new Expectations(){{
            oneOf(calendar).isDay(localDate,0);
            will(returnValue(true));
            oneOf(schedule).isTime(localTime);
            will(returnValue(false));
        }});

        PicoPlaca picoPlaca = new PicoPlaca(calendar,schedule);
        assertEquals("no pico-placa",false, picoPlaca.predict(plate,localDate,localTime));
    }
}
