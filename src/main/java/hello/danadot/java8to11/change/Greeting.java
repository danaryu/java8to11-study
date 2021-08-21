package hello.danadot.java8to11.change;

import java.util.Locale;

public interface Greeting {

    //인터페이스에 추상메소드가 추가되었을 경우, 해당 인터페이스를 구현한 모든 클래스가 compile error
    //default class로 추가

    void printName();

    /**
     * 기본 메소드 (default method)
     * 인터페이스 메소드 선언이 아니라 "구현체"를 제공하는 방법
     * 해당 인터페이스를 구현한 클래스를 깨뜨리지않고, 새 기능을 추가할 수 있다.
     * 하지만, 아래와 같이 상태 구현 내용에 대해 반드시 표기하여야한다.
     *
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */

    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase(Locale.ROOT));
    }

    String getName();

    /**
     * 정적 메소드 (static method)
     * 해당 타입 관련 헬퍼 또는 유틸리티 메소드를 제공할 때, 인터페이스에 스테틱 메소드를 제공할 수 있다.
     * 사용 예시 : Greeting.printAnything(); (GreetingMain 참고)
     */
    static void printAnything() {
        System.out.println("HELLOOW");
    }

}
