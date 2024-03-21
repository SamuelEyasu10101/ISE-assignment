public class temperatureValidator extends weatherTool {
    public String validateTemperature(String city, double temperature) {
        // Example with hardcoded values, should be replaced with actual data
        double minTemp, maxTemp, avgTemp;
        
        if ("Perth".equalsIgnoreCase(city)) {
            minTemp = 0.7;
            maxTemp = 46.0;
            avgTemp = 18.2;
        } else if ("Dubai".equalsIgnoreCase(city)) {
            minTemp = 1.5;
            maxTemp = 49.0;
            avgTemp = 26.9;
        } else {
            return "City not recognized.";
        }

        if (temperature < minTemp || temperature > maxTemp) {
            return "Invalid temperature range.";
        }

        if (Math.abs(temperature - avgTemp) > 6) {
            return "Temperature difference is greater than 6°C from the average.";
        } else {
            return "Temperature is within the normal range.";
        }
    }
}

