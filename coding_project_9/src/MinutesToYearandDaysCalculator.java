public class MinutesToYearandDaysCalculator {

    public static void printYearsAndDays(long minutes) {
        if(minutes >= 0) {
            long years = minutes / (60 * 24 * 365);
            long days = minutes % (60 * 24 * 365)/1440;
            System.out.println(minutes + " min = " + years + " y and " + days + " d");

        }else {
            System.out.println("Invalid Value");
        }
    }
}
