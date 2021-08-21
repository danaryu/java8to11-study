package hello.danadot.java8to11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("danadot");
        names.add("heepong");
        names.add("meeepong");
        names.add("danpong");

        Stream<String> stringStream = names.stream()
                .map(String::toUpperCase);
        
        // 실제 names의 데이터는 변화하지않음
        names.forEach(System.out::println);

        /**
         * 중계 오퍼레이션
         * 종료 오퍼레이션이 오기 전 까지는 실행되지 않는다. (lazy)
         * filter, map, limit, skip, sorted ...
         * 예) map : 요소들을 특정 조건에 해당하는 갑으로 변경해준다.
         */

        // 정의만 한 상태 (실행되지 않음)
        names.stream().map((str) -> {
            System.out.println("str = " + str);
            return str.toUpperCase();
        });

        //종료 오퍼레이터를 추가해주면 실행
        List<String> collect = names.stream().map((str) -> {
            System.out.println("str = " + str);
            return str.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

        System.out.println("======================");

        /**
         * 종료 오퍼레이션
         * collect, allMatch, forEach, min, max ...
         */

        names.forEach(System.out::println);

        /**
         * 손쉬운 병렬처리
         */

        System.out.println();

        // stream 미사용 : 병렬처리 힘듦
        for(String name : names) {
            if(name.startsWith("h")) {
                System.out.println(name.toUpperCase());
            }
        }

        /* stream 사용
            names.parallelStream().map(String::toUpperCase)
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
        */

        names.parallelStream().map((str) -> {
            System.out.println(str + " " + Thread.currentThread().getName());
            return str.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
