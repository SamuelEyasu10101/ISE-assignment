import java.util.Scanner;

public class weatherInsightProgram {

    public static String determineSeason(String country, String calendarType, int month) {
        if (month < 1 || month > 12) {
            return "Invalid month provided.";
        }

        switch (country.toLowerCase()) {
            case "australia":
                return determineSeasonAustralia(calendarType, month);
            case "uae":
            case "united arab emirates":
                return (month >= 5 && month <= 9) ? "Summer" : "Winter";
            case "malaysia":
            case "singapore":
                return (month <= 2 || month == 12) ? "Northeast Monsoon" : (month <= 4 || month >= 10) ? "Inter-monsoon" : "Southwest Monsoon";
            default:
                return "Season data not available for this country.";
        }
    }

    private static String determineSeasonAustralia(String calendarType, int month) {
        if ("noongar".equalsIgnoreCase(calendarType)) {
            switch (month) {
                case 12: case 1: return "Birak";
                case 2: case 3: return "Bunuru";
                case 4: case 5: return "Djeran";
                case 6: case 7: return "Makuru";
                case 8: case 9: return "Djilba";
                case 10: case 11: return "Kambarang";
                default: return "Unknown season";
            }
        } else {
            if (month >= 1 && month <= 3 || month == 12) return "Summer";
            else if (month >= 4 && month <= 6) return "Autumn";
            else if (month >= 7 && month <= 9) return "Winter";
            else return "Spring";
        }
    }

    public static String validateTemperature(String city, double temperature) {
        double minTemp, maxTemp, avgTemp;
        switch (city.toLowerCase()) {
            case "perth":
                minTemp = 0.7; maxTemp = 46.0; avgTemp = 18.2;
                break;
            case "dubai":
                minTemp = 1.5; maxTemp = 49.0; avgTemp = 26.9;
                break;
            default:
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
        System.out.println("Welcome to the Weather Insight Tool!");
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Find the season for a country and month.");
            System.out.println("2. Validate temperature for a city.");
            System.out.println("3. Exit the program.");
            System.out.print("\nEnter your choice here: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input, try again!");
                scanner.next();
                System.out.print("Enter your choice here: ");
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleSeasonFinder(scanner);
                    break;
                case 2:
                    handleTemperatureValidation(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void handleSeasonFinder(Scanner scanner) {
        while (true) {
            System.out.println("Available countries include UAE (United Arab Emirates), Singapore, Malaysia, Australia.");
            System.out.print("Enter the country: ");
            String country = scanner.nextLine();

            if (country.matches("\\d+")) {
    		System.out.println("Invalid input, please enter a valid country name.");
    		continue;
	    }

	    country = country.trim().toLowerCase();
	    if (!isValidCountry(country)) {
    		System.out.println("Outside range! Please enter a valid country from the list.");
    		continue;
	    }

	    String calendarType = "meteorological"; // Default calendar type
	    if ("australia".equals(country)) {
    		System.out.print("Enter the calendar type ('meteorological' or 'noongar'): ");
    		calendarType = scanner.nextLine().trim();
	    }

	    System.out.print("Enter the month (1-12): ");
	    while (!scanner.hasNextInt()) {
    		System.out.println("Invalid month; please enter a number between 1 and 12:");
    		scanner.next(); // consume the non-integer input
		}
	    int month = scanner.nextInt();
            scanner.nextLine(); // consume the newline character after the number

            String season = determineSeason(country, calendarType, month);
            System.out.println("Season: " + season);
            break; // Exit the while loop after successful operation
	}
}
    private static boolean isValidCountry(String country) {
    		return country.equals("uae") || country.equals("united arab emirates") ||
           	       country.equals("singapore") || country.equals("malaysia") ||
           	       country.equals("australia");
	}
	
    private static void handleTemperatureValidation(Scanner scanner) {
    	String city = "";
	boolean inRange = true;
    	while (inRange) {
        		System.out.print("Enter the city (Perth or Dubai): ");
        		city = scanner.nextLine().trim();

        		// Check if the city is valid and not a numeric value
        		if (!(city.equalsIgnoreCase("Perth") || city.equalsIgnoreCase("Dubai")) || city.matches("\\d+")) {
            			System.out.println("Invalid input. Please enter 'Perth' or 'Dubai'.");
            			continue;
        		}
        		inRange = false; // Exit the loop if a valid city is entered
    		     }

    	System.out.print("Enter the temperature: ");
    	while (!scanner.hasNextDouble()) {
        	System.out.print("Invalid input; please enter a valid temperature:");
        	scanner.next(); // consume the invalid input
    	}
    	double temperature = scanner.nextDouble();
    	scanner.nextLine(); // consume the newline character after the number

    	String validationMessage = validateTemperature(city, temperature);
    	System.out.println(validationMessage);
	}

}


