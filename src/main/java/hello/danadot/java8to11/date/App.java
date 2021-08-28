package hello.danadot.java8to11.date;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        long time = date.getTime();
        System.out.println("data는 날짜인데 왜 time이?! = " + time);
        System.out.println("date = " + date);

        // Mutable 객체의 값을 변경할 수 있음. 불변의 값이 아니다.
        // Thread Safe하지 않음
        /*
            Thread.sleep(1000 * 3);

            Date after3Seconds = new Date();
            System.out.println("after3Seconds = " + after3Seconds);
            after3Seconds.setTime(time);
            System.out.println("after3Seconds = " + after3Seconds);
        */

        // Month에 숫자를 쓰면.. 헷갈린다. Month는 0부터 시작, Type을 Constant로 설정해주어야함..
        // Type Safe 하지 않음
        Calendar danadotBirthday = new GregorianCalendar(1994, Calendar.MAY, 26);
        System.out.println("danadotBirthday는 왜 또 getTime...?! = " + danadotBirthday.getTime());

        // JSR-310 (+) Joda-time
        // Fluent, Immutable, Extendable
        danadotBirthday.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println("danadotBirthday.getTime() = " + danadotBirthday.getTime());

    }

}
