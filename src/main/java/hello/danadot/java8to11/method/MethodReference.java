package hello.danadot.java8to11.method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        //미리 선언된 메소드를 가져다 쓰는 경우
        Function<Integer, String> intToString = (number) -> "number";

        // 특정 객체의 레퍼런스 참고
        /*
            1. 입력 값과 결과 값의 타입이 같은 경우 : UnaryOperator
         */
        //UnaryOperator<String> hi = (str) -> "hi" + str ;

        //Static한 method reference
        UnaryOperator<String> hi = Greeting::hi;

        //instanc method 사용
        Greeting greeting = new Greeting();
        //메소드를 참조하는 UnaryOperator를 만든다.
        UnaryOperator<String> hello = greeting::hello;
        //UnaryOperator에 입력 값 전달하여 결과 값 반환
        String danadot = hello.apply("danadot");

        //생성자 참조
        /*
            2. 입력 값은 있는데, 결과 값이 없는 경우 : Supplier
         */
        Supplier<Greeting> newGreeting = Greeting::new;
        //Supplier에서 Greeting 객체를 꺼낸다.
        Greeting greetingBySupplier = newGreeting.get();

        /*
            3. 입력 값을 받는 생성자
         */
        Function<String, Greeting> greetingByFunction
                = Greeting::new;

        System.out.println("greetingByFunction.apply(\"danadot\").getName() = "
                + greetingByFunction.apply("danadot").getName());


        String[] names = {"danadot", "heepong", "meepong"};

        /*
            Arrays.sort(names, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);;
                }
            });

            FunctionalInterface인 Comparator의 compare method사용하여 String비교
            이 때, String의 compareToIgnoreCase" method를 참조한다
            String의 내장 Comparator를 이용해 compareToIgnoreCase로 사용 가능
         */

        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("Arrays.toString(names) = " + Arrays.toString(names));

    }

}
