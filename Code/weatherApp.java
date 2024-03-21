public class weatherApp {
    public static void main(String[] args) {
        seasonFinder seasonFinder = new seasonFinder();
        String season = seasonFinder.determineSeason("Australia", 3);
        System.out.println("Season: " + season);

        temperatureValidator temperatureValidator = new temperatureValidator();
        String tempValidation = temperatureValidator.validateTemperature("Perth", 10);
        System.out.println("Temperature Validation: " + tempValidation);
    }
}

