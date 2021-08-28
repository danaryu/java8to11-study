package hello.danadot.java8to11.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeAPI {

    public static void main(String[] args) {

        /* 1. Instance : 기계 시간으로 표현 */
        Instant now = Instant.now();
        System.out.println("now = " + now); // 기준시, UTC/GMT
        System.out.println("now.atZone(ZoneId.of(\"UTC\")) = " + now.atZone(ZoneId.of("UTC")));

        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault()); // 현재 SystemDefault
        System.out.println("zonedDateTime = " + zonedDateTime); 

        /* 2. LocalDateTime : 인류용..ㅎㅎ */
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("now2 = " + now2);
        LocalDateTime danadotBirthday = LocalDateTime.of(1994, 4, 26, 9, 15);
        System.out.println("danadotBirthday = " + danadotBirthday);

        /* 3. ZonedDateTime */
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTime1 = " + zonedDateTime1);

        /* 4. 기간을 표현하는 방법 */
        LocalDate today = LocalDate.now();
        LocalDate nextYearBirthday = LocalDate.of(2022, Month.MAY, 26);

        // Human용..ㅎ
        Period period = Period.between(today, nextYearBirthday);
        System.out.println("period.getDays() = " + period.getDays());

        Period until = today.until(nextYearBirthday);
        System.out.println("until = " + until.get(ChronoUnit.DAYS));

        // Mechine용
        Instant now1 = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(now, plus);
        System.out.println("duration.getSeconds() = " + duration.getSeconds());

        /* 4. parsing, formatting */
        //formatting
        LocalDateTime now3 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("formatting now 3 " + now3.format(MMddyyyy));

        //parsing
        LocalDate parse = LocalDate.parse("04/26/1994", MMddyyyy);
        System.out.println("parse = " + parse);

        /* 5. Legacy API 지원 */
        Date date = new Date();
        Instant instant = date.toInstant();
        Date newDate = Date.from(instant);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        ZonedDateTime zonedDateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());

        GregorianCalendar from = GregorianCalendar.from(zonedDateTime2);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone.getTimeZone(zoneId);

    }

}
