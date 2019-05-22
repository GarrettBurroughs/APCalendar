public class APCalendar {

    private static boolean isLeapYear(int year){
        return (year % 4 == 0 && !(year % 100 == 0)) || (year % 400 == 0);
    }

    public static int numberOfLeapYears(int year1, int year2) {
        int years = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                years++;
            }
        }
        return years;
    }

    private static int firstDayOfYear(int year){
        int offset;
        if(year > 1970){
            offset = numberOfLeapYears(1970, year);
        }else{
            offset = -numberOfLeapYears(year, 1970);
        }
        return (int)wrap((4 + (year - 1970) + offset), 0, 7);
    }

    private static int dayOfYear(int month, int day, int year){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(year)){
            days[1] = 29;
        }
        int totalDays = day;
        for(int i = 1; i < month; i++){
            totalDays += days[i];
        }
        return totalDays;
    }

    public static int dayOfWeek(int month, int day, int year){
        return (dayOfYear(month, day, year) + firstDayOfYear(year) - 1) % 7;
    }

    public static double wrap(double in, double min, double max) {
        double diff = min - max;
        return ((in - min) % diff + diff) % diff + max;
    }
}
