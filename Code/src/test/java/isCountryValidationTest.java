import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class isCountryValidationTest {

    @Test
    public void whenValidCountry_thenShouldReturnTrue() {
        boolean result = weatherInsightProgram.isValidCountry("australia");
        Assertions.assertTrue(result);
    }

    @Test
    public void whenInvalidCountry_thenShouldReturnFalse() {
        boolean result = weatherInsightProgram.isValidCountry("westeros");
        Assertions.assertFalse(result);
    }
}

