package hello.danadot.java8to11.change;

public interface Bar extends Greeting {

    //Bar에서는 Greeting interface의 구현체를 구현하고 싶지 않을 때
    //인터페이스를 상속하는 인터페이스의 경우 추상메소드로 구현체를 변경할 수 있다.
    void printNameUpperCase();

}
