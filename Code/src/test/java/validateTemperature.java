import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class validateTemperature {

    @Test
    public void testValidTemperatureWithinRange_Perth() {
        Assertions.assertEquals("Temperature is within the normal range.", weatherInsightProgram.validateTemperature("perth", 20.0));
    }

    @Test
    public void testTemperatureBelowMinimum_Dubai() {
        Assertions.assertEquals("Invalid temperature range.", weatherInsightProgram.validateTemperature("dubai", 0.0));
    }

    @Test
    public void testTemperatureAboveMaximum_Dubai() {
        Assertions.assertEquals("Invalid temperature range.", weatherInsightProgram.validateTemperature("dubai", 50.0));
    }

    @Test
    public void testTemperatureNearAverageValid_Perth() {
        Assertions.assertEquals("Temperature is within the normal range.", weatherInsightProgram.validateTemperature("perth", 24.2));
    }

    @Test
    public void testCityNotRecognized_Gotham() {
        Assertions.assertEquals("City not recognized.", weatherInsightProgram.validateTemperature("gotham", 15.0));
    }

    @Test
    public void testTemperatureDifferenceGreaterThan6_Dubai() {
        Assertions.assertEquals("Temperature difference is greater than 6°C from the average.", weatherInsightProgram.validateTemperature("dubai", 35.0));
    }
}


