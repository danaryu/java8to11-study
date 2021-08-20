package hello.danadot.java8to11.functional;

import hello.danadot.java8to11.functional.RunSomething;

public class FunctionalInterface1 {


    public static void main(String[] args) {
        /* 익명 내부 클래스 : anonymous inner class
            RunSomething runSomething = new RunSomething() {
                @Override
                public void doIt() {
                    System.out.println("Hello");
                }
            };
         */

        // lambda형태로 표현할 수 있음
        // runSomething == runSomthing1
        // 자바에서 함수는 "Object"
        //RunSomething runSomething1 = () -> System.out.println("Hello");
        //runSomething1.doIt();
        
        RunSomething runSomething =  (number) -> {
            return number + 10;
        };
    }


}
