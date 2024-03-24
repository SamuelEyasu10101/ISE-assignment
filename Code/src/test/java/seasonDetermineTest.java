import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class seasonDetermineTest {

    @Test
    public void testDetermineSeason_Australia_Summer() {
        assertEquals("Summer", weatherInsightProgram.determineSeason("australia", "meteorological", 1),
                "January in Australia (meteorological calendar) should be Summer.");
    }

    @Test
    public void testDetermineSeason_Australia_Makuru() {
        assertEquals("Makuru", weatherInsightProgram.determineSeason("australia", "noongar", 6),
                "June in Australia (Noongar calendar) should be Makuru.");
    }

    @Test
    public void testDetermineSeason_InvalidCountry() {
        assertEquals("Season data not available for this country.", weatherInsightProgram.determineSeason("atlantis", "meteorological", 5),
                "Atlantis is not a recognized country.");
    }

    @Test
    public void testDetermineSeason_Australia_InvalidMonthLow() {
        assertEquals("Invalid month provided.", weatherInsightProgram.determineSeason("australia", "meteorological", 0),
                "Month 0 is out of valid range.");
    }

    @Test
    public void testDetermineSeason_Australia_InvalidMonthHigh() {
        assertEquals("Invalid month provided.", weatherInsightProgram.determineSeason("australia", "meteorological", 13),
                "Month 13 is out of valid range.");
    }

    @Test
    public void testDetermineSeason_UAE_Summer() {
        assertEquals("Summer", weatherInsightProgram.determineSeason("uae", "meteorological", 7),
                "July in UAE (meteorological calendar) should be Summer.");
    }

    @Test
    public void testDetermineSeason_Singapore_InterMonsoon() {
        assertEquals("Inter-monsoon", weatherInsightProgram.determineSeason("singapore", "meteorological", 10),
                "October in Singapore should be Inter-monsoon.");
    }
}

