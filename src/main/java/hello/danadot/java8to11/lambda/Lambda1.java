package hello.danadot.java8to11.lambda;

import org.apache.tomcat.jni.Local;

import java.util.function.*;

public class Lambda1 {


    public static void main(String[] args) {
        // (Param) -> (Body)
        Supplier<Integer> get10 = () -> {
            return 10;
        };

        Supplier<Integer> simpleGet10 = () -> 10;

        //BiFunction<Integer, Integer, Integer>
        //BinarayOperator<Integer> sum = (Integer a, Integer b) -> a + b;
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println("sum.apply = " + sum.apply(1, 2));

        // 변수 캡쳐
        Lambda1 foo = new Lambda1();
        foo.run();

    }


    private void run() {

        // final을 생략할 수 있는 경우 : 뒤에서 전혀 변경이 불가능 한 경우 final 생략 가능, effective final
        int baseNumber = 10;

        // 익명 Class
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println("baseNumber ANONYMOUS = " + baseNumber);  // 11 Shadowing O
            }
        };

        // 로컬 Class
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println("baseNumber LOCAL = " + baseNumber); // 11 Shadowing O
            }
        }

        /*
            Shadowing O : local, anonymous
                별도 Scope이기 때문에
            but Lambada는 Shadowing이 일어나지 않는다. Scope이 run과 같기 때문에!
         */


        // Lambda
        IntConsumer printInteger = (i) -> {
            //lambda에서 baseNumber 참조
            System.out.println("i + baseNumber LAMBDA = " + i + baseNumber);
        };

        printInteger.accept(7);

        LocalClass local = new LocalClass();
        local.printBaseNumber();

        integerConsumer.accept(1);

    }
}
