package hello.danadot.java8to11;

@FunctionalInterface
public interface RunSomething {

    // 1. Functional Interface
    // interface는 abstract를 생략해도 추상메소드이다.
    // 추상메소드를 하나만 가지고 있는 인터페이스는 함수형 인터페이스이다.
    //void doIt();

    int doIt(int number);

    /*
        추상 method가 아닌 method가 있어도, 추상메서드가 하나라면 functional interface이다!

    // public 생략 가능
    static void printName() {
        System.out.println("danadottt");
    }

    default void printAge() {
        System.out.println("28");
    }

     */

}
