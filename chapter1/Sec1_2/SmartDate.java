import java.util.Arrays;

public class SmartDate {

//    1.2.11 Develop an implementation SmartDate of our Date API that raises an exception if the date is not legal.
//1.2.12 Add a method dayOfTheWeek() to SmartDate that returns a String value
//    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday, giving the appropriate day of the week for the date.
//    You may assume that the date is in the 21st
//    century.


    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int m, int d, int y) {

        assert d > 0 : "Wrong Input";

        if ((d < 0) || (d > 31)) {
            throw new IllegalArgumentException("Invalid Day. Check your input");
        }
        if ((m < 0) || (m > 12)) {
            throw new IllegalArgumentException("Invalid Month. Check your input");
        }
        if ((y < 2000) || (y > 2100)) {
            throw new IllegalArgumentException("Invalid Year. Check your input");
        }

        if (m == 2) {
            if (d > 29) {
                throw new IllegalArgumentException("February can have at most 29 days");
            } else if ((y % 4 != 0) & (d == 29)) {
                throw new IllegalArgumentException("Not a leap year. February can have at most 28 days");
            } else {
                ;
            }
        } else if (Arrays.asList(4, 6, 9, 11).contains(m)) {
            if (d > 30) {
                throw new IllegalArgumentException("Provided month only has 30 days");
            }
        } else {
            ;
        }

        month = m;
        day = d;
        year = y;

        System.out.println("Date object successfully created");

    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public String dayOfTheWeek() {

        int days = 0;

        for (int i = 2000; i < year; i++) {
            if (i % 4 == 0) {
                days += 366;
            } else {
                days += 365;
            }
        }

        for (int i = 1; i < month; i++) {
            if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(i)) {
                days += 31;
            } else if (i == 2) {
                if (year % 4 == 0) {
                    days += 29;
                } else {
                    days += 28;
                }
            } else {
                days += 30;
            }
        }

        days += day - 1;

        if ((days % 7) == 0) return "Saturday";
        if ((days % 7) == 1) return "Sunday";
        if ((days % 7) == 2) return "Monday";
        if ((days % 7) == 3) return "Tuesday";
        if ((days % 7) == 4) return "Wednesday";
        if ((days % 7) == 5) return "Thursday";
        if ((days % 7) == 6) return "Friday";

        return "Error";
    }

    public static void main(String[] args) {
        SmartDate test = new SmartDate(-11, -12, 2014);
        System.out.println(test.toString());
        System.out.println(test.dayOfTheWeek());
    }
}
