public class seasonFinder extends weatherTool {
    public String determineSeason(String country, int month) {
        // Simplified logic, should be expanded based on actual data
        if ("Australia".equalsIgnoreCase(country)) {
            if (month >= 12 || month <= 2) return "Summer";
            if (month >= 3 && month <= 5) return "Autumn";
            if (month >= 6 && month <= 8) return "Winter";
            if (month >= 9 && month <= 11) return "Spring";
        } else if ("UAE".equalsIgnoreCase(country)) {
            if (month >= 5 && month <= 9) return "Summer";
            else return "Winter";
        }
        return "Unknown Season"; // Default case
    }
}

