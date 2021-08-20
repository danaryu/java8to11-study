package hello.danadot.java8to11.functional;

import java.util.function.*;

public class FunctionalInterfaceMain {

    public static void main(String[] args) {
        FunctionalInterface2 lambda = new FunctionalInterface2();

        Function<Integer, Integer> lambda2 = (number) -> number + 10;
        Function<Integer, Integer> multiply2 = (number1) -> number1 * 2;

        System.out.println(lambda.apply(1));
        System.out.println(multiply2.apply(1));

        Function<Integer, Integer> multiply2AndPlus10 = lambda2.compose(multiply2);
        System.out.println("multiply2AndPlus10.apply(2) = " + multiply2AndPlus10.apply(2));

        Function<Integer, Integer> andThenFunc = lambda2.andThen(multiply2);
        System.out.println("andThenFunc.apply(2) = " + andThenFunc.apply(2));

        // 리턴값이 없음 (입력값 only)
        Consumer<Integer> printT = (i) -> System.out.println("i = " + i);
        printT.accept(10);

        //입력값 없이 리턴값 고정
        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 = " + get10.get());

        // True, false (boolean) return
        Predicate<String> startsWithDanadot = (s) -> s.startsWith("dana");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        //입력 값과 리턴 값이 동일 한 경우
        UnaryOperator<Integer> plus10 = (i) -> i+10;
    }

}
