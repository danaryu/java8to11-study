package hello.danadot.java8to11.stream;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "Spring boot", true));
        springClasses.add(new OnlineClass(2, "Spring data jpa", true));
        springClasses.add(new OnlineClass(3, "Spring mvc", false));
        springClasses.add(new OnlineClass(4, "Spring core", false));
        springClasses.add(new OnlineClass(5, "Rest Api Development", false));

        System.out.println("1. Spring으로 시작하는 수업 ");

/*
        List<String> classList =
            springClasses.stream().map((onlineClass) -> {
                if(onlineClass.getTitle().startsWith("Spring")) {
                    return onlineClass.getTitle();
                }
                return null;
            }).collect(Collectors.toList());
        classList.forEach(System.out::println);
*/

        springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("Spring"))
                .forEach(onlineClass -> System.out.print(onlineClass.getId() + " "));

        System.out.println("\n2. close 되지 않은 수업");
        springClasses.stream()
                .filter(onlineClass -> !onlineClass.isClosed())
                .forEach(onlineClass -> System.out.print(onlineClass.getId() + " "));

        System.out.println();
        //method reference로 단축
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(onlineClass -> System.out.print(onlineClass.getId() + " "));

        System.out.println("\n3. 수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(onlineClass -> onlineClass.getTitle())
                .forEach(System.out::println);

        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> danadotEvents = new ArrayList<>();
        danadotEvents.add(springClasses);
        danadotEvents.add(javaClasses);

        System.out.println("4. 두 수업 목록에 들어있는 모든 수업 아이디 출력");
        /*
        danadotEvents.stream()
            .forEach(onlineClassList -> onlineClassList
                    .forEach(onlineClass -> System.out.println(onlineClass.getTitle())));

         */

        danadotEvents.stream().flatMap(Collection::stream)
                     .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        System.out.println("5. 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(BigDecimal.ZERO, num -> num.add(BigDecimal.ONE))
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("6. 자바 수업중에 Test가 들어있는 수업이 있는지 확인");
/*        javaClasses.stream()
                .filter(javaClass -> javaClass.getTitle().contains("Test"))
                .forEach(javaClass -> System.out.println(javaClass.getTitle()));
*/

        boolean anyMatch = javaClasses.stream().anyMatch(onlineClass -> onlineClass.getTitle().contains("Test"));
        System.out.println("anyMatch = " + anyMatch);

        System.out.println("7. 스프링 수업중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");

        List<String> spring = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().contains("Spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);


    }

}
