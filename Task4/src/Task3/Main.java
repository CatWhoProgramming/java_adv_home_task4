package Task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) throws ParseException {
        LocalDateTime dateTime = LocalDateTime.of(2023, 6, 20, 0, 0);
        LocalDateTime dateTime2 = LocalDateTime.now();

        long diffInNano = ChronoUnit.NANOS.between(dateTime, dateTime2);
        long diffInSeconds = ChronoUnit.SECONDS.between(dateTime, dateTime2);
        long diffInMilli = ChronoUnit.MILLIS.between(dateTime, dateTime2);
        long diffInMinutes = ChronoUnit.MINUTES.between(dateTime, dateTime2);
        long diffInHours = ChronoUnit.HOURS.between(dateTime, dateTime2);
        long diffInDays = ChronoUnit.DAYS.between(dateTime, dateTime2);
        System.out.println(diffInNano);
        System.out.println(diffInHours);
        System.out.println(diffInMinutes);
        System.out.println(diffInSeconds);
        System.out.println(diffInMilli);

        System.out.println(diffInDays);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse("28.01.2009", formatter);
        LocalDate endDate = LocalDate.parse("05.03.2013", formatter);
        Period period = Period.between(startDate, endDate);
        System.out.println(period.getYears());      // 4
        System.out.println(period.getMonths());     // 1
        System.out.println(period.getDays());

        LocalDate localDate = LocalDate.now();
        System.out.println("=============");
        localDate = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(localDate);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        long timeUp = format.parse("2023/06/20 19:00:00").getTime();
        long diff = System.currentTimeMillis() - timeUp;

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        StringBuilder sb = new StringBuilder();
        sb.append(diffDays).append(" дней, ");
        sb.append(diffHours).append(" часов, ");
        sb.append(diffMinutes).append(" минут, ");
        sb.append(diffSeconds).append(" секунд");

        System.out.println(sb);
    }
}
