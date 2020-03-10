
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TestDate {

    public static void main(String[] args) throws Exception {
        LocalDate ld1=LocalDate.now();
        System.out.println(ld1);
        LocalDate ld2= LocalDate.of(2017, 1, 31);
        System.out.println(ld2);
        DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM, dd");
        System.out.printf("%s",df.format(ld2));
        /*System.out.println("LocalDate is A date without a time-zone such as 2007-12-03.");
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2018, 1, 20);
        LocalDate ld3 = LocalDate.of(2018, Month.JANUARY, 30);
        LocalDate ld4 = LocalDate.of(2018, 10, 31);
        System.out.println("ld1: " + ld1);
        System.out.println("ld2: " + ld2);
        System.out.println("ld3: " + ld3);
        System.out.println("ld4: " + ld4);

        System.out.println("\nFormat Date...");
        DateTimeFormatter sdf1 = DateTimeFormatter.ofPattern("yyyy-MM, dd");
        DateTimeFormatter sdf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("format(ld1) : " + sdf1.format(ld1));
        System.out.println("format(ld2) : " + sdf1.format(ld2));
        System.out.println("format(ld3) : " + sdf2.format(ld3));
        System.out.println("format(ld4) : " + sdf2.format(ld4));

        System.out.println("\nis before, after, or equals between Two Dates...");
        if (ld2.isBefore(ld1)) {
            System.out.println("Date2 is before Date1");
        }
        if (ld1.isAfter(ld3)) {
            System.out.println("Date1 is after Date3");
        }
        if (ld3.isEqual(ld4)) {
            System.out.println("Date3 is equal Date4");
        }
        if (ld1.isEqual(ld4)) {
            System.out.println("Date1 is equal Date4");
        }

        System.out.println("\nCompare less, greater than, or equals...");
        if (ld1.compareTo(ld2) > 0) {
            System.out.println("Date1 is after Date2");

        } else if (ld1.compareTo(ld2) < 0) {
            System.out.println("Date1 is before Date2");

        } else if (ld1.compareTo(ld2) == 0) {
            System.out.println("Date1 is equal to Date2");

        }*/
    }
}

