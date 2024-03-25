import java.util.Scanner;

public class weatherInsightProgram {
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

            int choice = getInputAsInt(scanner);

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
    
    public static String validateTemperature(String city, double temperature) {
    	double minTemp = 0.0, maxTemp = 0.0, avgTemp = 0.0; // Initialize variables
    	switch (city.toLowerCase()) {
        	case "perth": {
            		minTemp = 0.7; maxTemp = 46.0; avgTemp = 18.2;
           		break; // Break is necessary to exit the switch after a case is matched
        	}
        	case "dubai": {
            		minTemp = 1.5; maxTemp = 49.0; avgTemp = 26.9;
            		break;
        	}
        	default: {
            		return "City not recognized.";
       		 }
    }

    	if (temperature < minTemp || temperature > maxTemp) {
        	return "Invalid temperature range.";
    	} else if (Math.abs(temperature - avgTemp) > 6) {
        	return "Temperature difference is greater than 6°C from the average.";
    	} else {
        	return "Temperature is within the normal range.";
    	}
     }
    private static int getInputAsInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, try again!");
            scanner.next(); // Clear the invalid input
            System.out.print("Enter your choice here: ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        return choice;
    }

    private static void handleSeasonFinder(Scanner scanner) {
        System.out.println("Available countries include UAE (United Arab Emirates), Singapore, Malaysia, Australia.");
        System.out.print("Enter the country: ");
        String country = scanner.nextLine().trim().toLowerCase();
        
        if (!isValidCountry(country)) {
            System.out.println("Invalid input or country not recognized.");
            return;
        }

        String calendarType = "meteorological";
        if ("australia".equals(country)) {
            System.out.print("Enter the calendar type ('meteorological' or 'noongar'): ");
            calendarType = scanner.nextLine().trim();
        }

        System.out.print("Enter the month (1-12): ");
        int month = getInputAsInt(scanner);

        String season = determineSeason(country, calendarType, month);
        System.out.println("Season: " + season);
    }

    private static void handleTemperatureValidation(Scanner scanner) {
        System.out.print("Enter the city (Perth or Dubai): ");
        String city = scanner.nextLine().trim();
        System.out.print("Enter the temperature: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input; please enter a valid temperature:");
            scanner.next(); // Consume invalid input
        }
        double temperature = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        String validationMessage = validateTemperature(city, temperature);
        System.out.println(validationMessage);
    }

    public static boolean isValidCountry(String country) {
        return switch (country) {
            case "uae", "united arab emirates", "singapore", "malaysia", "australia" -> true;
            default -> false;
        };
    }

    
    public static String determineSeason(String country, String calendarType, int month) {
        if (month < 1 || month > 12) return "Invalid month provided.";
        
        switch (country.toLowerCase()) {
            case "australia":
                return determineSeasonAustralia(calendarType, month);
            case "uae":
            case "united arab emirates":
                return (month >= 5 && month <= 9) ? "Summer" : "Winter";
            case "malaysia":
            case "singapore":
                return (month <= 2 || month == 12) ? "Northeast Monsoon" : 
                       (month <= 4 || month >= 10) ? "Inter-monsoon" : "Southwest Monsoon";
            default:
                return "Season data not available for this country.";
        }
    }

    //used to validate validate and determine the season in austrila is it the conventional(meathodiacal) or noongar.
    private static String determineSeasonAustralia(String calendarType, int month) {
        if ("noongar".equalsIgnoreCase(calendarType)) {
            return switch (month) {
                case 12, 1 -> "Birak";
                case 2, 3 -> "Bunuru";
                case 4, 5 -> "Djeran";
                case 6, 7 -> "Makuru";
                case 8, 9 -> "Djilba";
                case 10, 11 -> "Kambarang";
                default -> "Unknown season";
            };
        } else {
            return switch (month) {
                case 12, 1, 2, 3 -> "Summer";
                case 4, 5, 6 -> "Autumn";
                case 7, 8, 9 -> "Winter";
                default -> "Spring";
            };
        }
    }
}
