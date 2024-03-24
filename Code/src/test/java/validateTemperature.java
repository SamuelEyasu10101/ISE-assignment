import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class validateTemperature {

    @Test
    void testValidTemperatureWithinRange() {
        assertEquals("Temperature is within the normal range.", weatherInsightProgram.validateTemperature("Perth", 20.0));
    }

    @Test
    void testTemperatureBelowMinimum() {
        assertEquals("Invalid temperature range.", weatherInsightProgram.validateTemperature("Dubai", 0.0));
    }

    @Test
    void testTemperatureAboveMaximum() {
        assertEquals("Invalid temperature range.", weatherInsightProgram.validateTemperature("Dubai", 50.0));
    }

    @Test
    void testTemperatureNearAverageValid() {
        assertEquals("Temperature is within the normal range.", weatherInsightProgram.validateTemperature("Perth", 24.2));
    }

    @Test
    void testCityNotRecognized() {
        assertEquals("City not recognized.", weatherInsightProgram.validateTemperature("Gotham", 15.0));
    }

    @Test
    void testTemperatureDifferenceGreaterThan6() {
        assertEquals("Temperature difference is greater than 6°C from the average.", weatherInsightProgram.validateTemperature("Dubai", 35.0));
    }
}

