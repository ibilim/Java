import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

public class LocalDateExamples {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        LocalDate valentine=LocalDate.of(2022,2,14);
        System.out.println(today);
        System.out.println(valentine);
        System.out.printf("Year: %d %n" +
                            "Month: %d%n" +
                            "Day:%d %n" +
                            "Day of Week:%s%n" +
                            "Day of Year:%d%n",valentine.getYear(),
                valentine.getMonthValue(),valentine.getDayOfMonth(),valentine.getDayOfWeek(),valentine.getDayOfYear());
        valentine=valentine.withYear(2000).withMonth(3).withDayOfMonth(31);
        valentine=valentine.plusYears(2).plusDays(50);
        System.out.println(valentine);

        DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL); //funktioniert nicht warum?
        DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate aDate=LocalDate.parse("05.06.2020",formatter2);
        System.out.println(aDate);
        LocalDate birthday=LocalDate.of(1985,8,10);
        System.out.println(birthday.format(formatter2));

        if (birthday.isBefore(LocalDate.of(1988, 2, 2))) {
            System.out.println("You are old");
        }
        if (birthday.isAfter(LocalDate.EPOCH)) {
            System.out.println("You were born after EPOCH.");
        }
        if (birthday == LocalDate.EPOCH) {
            System.out.println("You are EPOCH child ");
        }

        LocalDate lastday=birthday.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastday);

        LocalDate next_Saturday=birthday.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(next_Saturday);

        System.out.println(birthday.getDayOfWeek());

        LocalDate first_monday=birthday.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(first_monday);

    }

}
