import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class seasonDetermineTest {

    @Test
    public void testValidCountryWithMeteorologicalCalendar_AustraliaSummer() {
        Assertions.assertEquals("Summer", weatherInsightProgram.determineSeason("australia", "meteorological", 1));
    }

    @Test
    public void testCountryWithTwoCalendarTypes_AustraliaNoongarMakuru() {
        Assertions.assertEquals("Makuru", weatherInsightProgram.determineSeason("australia", "noongar", 6));
    }

    @Test
    public void testInvalidCountry_Atlantis() {
        Assertions.assertEquals("Invalid input or country not recognized.", weatherInsightProgram.determineSeason("atlantis", "", 5));
    }

    @Test
    public void testInvalidMonthLowBoundary() {
        String result = weatherInsightProgram.determineSeason("australia", "Gregorian", 0);
        Assertions.assertEquals("Invalid month provided.", result);
    }

    @Test
    public void testInvalidMonthHighBoundary() {
        String result = weatherInsightProgram.determineSeason("australia", "Gregorian", 13);
        Assertions.assertEquals("Invalid month provided.", result);
    }

    @Test
    public void testNonAustraliaCountryValidInput_UAESummer() {
        Assertions.assertEquals("Summer", weatherInsightProgram.determineSeason("uae", "", 7));
    }

    @Test
    public void testSingaporeWithInterMonsoon() {
        Assertions.assertEquals("Inter-monsoon", weatherInsightProgram.determineSeason("singapore", "", 10));
    }
}

