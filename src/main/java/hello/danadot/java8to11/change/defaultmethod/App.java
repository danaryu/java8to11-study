package hello.danadot.java8to11.change.defaultmethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();

        name.add("danadot");
        name.add("heepong");
        name.add("meepong");
        name.add("danpong");
        name.add("pongppong");

        /**
         * Iterable, Collection의 기본 메소드
         * @param Consumer<T>
         */

/*
    1. forEach

        for(String n : name) {
            System.out.println(n);
        }

        name.forEach(str -> {
            System.out.println("str = " + str);
        });
*/
        name.forEach(System.out::println);

/*
    2. spliterator : 쪼갤 수 있는 기능을 가진 iterator
 */

        Spliterator<String> spliterator = name.spliterator();

        //trysplit : name의 값을 2개의 spliterator에 나눠담는다
        Spliterator<String> stringSpliterator = spliterator.trySplit();

        // tryAdvance == hasNext
        while (spliterator.tryAdvance(System.out::println));

        System.out.println("========================");
        while (stringSpliterator.tryAdvance(System.out::println));

/*
    3. removeIf
 */

        System.out.println("========================");

        name.removeIf(str -> str.startsWith("h"));

        name.forEach(System.out::println);


/*
    @FunctionalInterface
    4. Comparator
*/
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);


    }

}
