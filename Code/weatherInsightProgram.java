import java.util.Scanner;

public class weatherInsightProgram {

    public static String determineSeason(String country, String calendarType, int month) {
        // Check if the month is valid
        if (month < 1 || month > 12) {
            return "Invalid month provided.";
        }

        switch (country.toLowerCase()) {
            case "australia":
                if ("noongar".equalsIgnoreCase(calendarType)) {
                    if (month == 12 || month == 1) return "Birak";
                    else if (month == 2 || month == 3) return "Bunuru";
                    else if (month == 4 || month == 5) return "Djeran";
                    else if (month == 6 || month == 7) return "Makuru";
                    else if (month == 8 || month == 9) return "Djilba";
                    else if (month == 10 || month == 11) return "Kambarang";
                } else if ("meteorological".equalsIgnoreCase(calendarType)) {
                    if (month >= 1 && month <= 2 || month == 12) return "Summer";
                    else if (month >= 3 && month <= 5) return "Autumn";
                    else if (month >= 6 && month <= 8) return "Winter";
                    else if (month >= 9 && month <= 11) return "Spring";
                }
                break;

            case "uae":
	    case "united arab emirates":
    		if (month >= 5 && month <= 9) {
        	  	return "Summer";
    		} else if ((month >= 10 && month <= 12) || (month >= 1 && month <= 4)) {
        		return "Winter";
    		}
    		break;

            case "malaysia":
            case "singapore":
                if (month == 12 || month == 1 || month == 2) return "Northeast Monsoon";
                else if (month == 3 || month == 4) return "Inter-monsoon";
                else if (month >= 5 && month <= 9) return "Southwest Monsoon";
                else if (month == 10 || month == 11) return "Inter-monsoon";
                break;
            default:
                return "Season data not available for this country.";
        }
        return "No season data available for the given parameters.";
    }

    public static String validateTemperature(String city, double temperature) {
        double minTemp, maxTemp, avgTemp;

        if ("perth".equalsIgnoreCase(city)) {
            minTemp = 0.7;
            maxTemp = 46.0;
            avgTemp = 18.2;
        } else if ("dubai".equalsIgnoreCase(city)) {
            minTemp = 1.5; // Adjusted to realistic values
            maxTemp = 48.0;
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

        System.out.println("Welcome to weather insight tool!");
        System.out.println("Please choose an option:");
        System.out.println("1. Find the season for a country and month");
	System.out.println();
        System.out.println("2. Validate temperature for a city.");

	System.out.print("Enter your choose here: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
   	    case 1:
		System.out.println("avaliable countries include UAE(united arab emirates), Singapore, Malaysia, Austrila");
        	System.out.print("Enter the country:");
        	String country = scanner.nextLine();
        	String calendarType = "meteorological";

        	if (country.equalsIgnoreCase("australia")) {
            	System.out.println("Enter the calendar type ('meteorological' or 'noongar'):");
            	calendarType = scanner.nextLine(); // Changed to nextLine()
        	}
	       	else {
            		calendarType = "meteorological"; // Assuming default calendar type for other countries
        	     }

        	System.out.print("Enter the month (1-12):");
        	int month = scanner.nextInt();
        	scanner.nextLine(); // Consume newline after nextInt
        	System.out.println("Season: " + determineSeason(country, calendarType, month));
        	break;

            case 2:
                System.out.print("Enter the city:");
                String city = scanner.nextLine();
                System.out.print("Enter the temperature:");
                double temperature = scanner.nextDouble();
                scanner.nextLine(); // Consume newline after nextDouble
                System.out.println(validateTemperature(city, temperature));
                break;
            default:
                System.out.println("Invalid option. Exiting program.");
                break;
        }

        scanner.close();
    }
}
