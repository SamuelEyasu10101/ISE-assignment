import java.util.Scanner;

public class weatherInsightProgram {
    
    public static String determineSeason(String country, int month) {
        switch (country.toLowerCase()) {
            case "australia":
                if (month >= 1 && month <= 2 || month == 12) return "Summer";
                if (month >= 3 && month <= 5) return "Autumn";
                if (month >= 6 && month <= 8) return "Winter";
                if (month >= 9 && month <= 11) return "Spring";
                break;
            case "uae":
                if (month >= 5 && month <= 9) return "Summer";
                if (month >= 10 && month <= 4) return "Winter";
                break;
            default:
                return "Season data not available for this country.";
        }
        return "Invalid month provided.";
    }

    public static String validateTemperature(String city, double temperature) {
        double minTemp, maxTemp, avgTemp;
        
        if ("perth".equalsIgnoreCase(city)) {
            minTemp = 0.7;
            maxTemp = 46.0;
            avgTemp = 18.2;
        } else if ("dubai".equalsIgnoreCase(city)) {
            minTemp = 1.5;
            maxTemp = 49.0;
            avgTemp = 26.9;
        } else {
            return "City not recognized.";
        }
        
        if (temperature < minTemp || temperature > maxTemp) {
            return "Invalid temperature range.";
        } else if (Math.abs(temperature - avgTemp) > 6) {
            return "Temperature difference is greater than 6°C from the average.";
        } else {
            return "Temperature is within the normal range.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the weather insight program!");
        System.out.println("Please choose an option:");
        System.out.println("1. Find the season for a country and month.");
        System.out.println("2. Validate temperature for a city.");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter the country:");
                String country = scanner.nextLine();
                System.out.println("Enter the month (1-12):");
                int month = scanner.nextInt();
                System.out.println("Season: " + determineSeason(country, month));
                break;
            case 2:
                System.out.println("Enter the city:");
                String city = scanner.nextLine();
                System.out.println("Enter the temperature:");
                double temperature = scanner.nextDouble();
                System.out.println(validateTemperature(city, temperature));
                break;
            default:
                System.out.println("Invalid option. Exiting program.");
                break;
        }

        scanner.close();
    }
}

