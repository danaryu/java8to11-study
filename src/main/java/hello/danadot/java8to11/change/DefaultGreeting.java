package hello.danadot.java8to11.change;

import java.util.Locale;

public class DefaultGreeting implements Greeting {

    String name;

    public DefaultGreeting(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    //default method는 재정의도 가능하다.
    @Override
    public void printNameUpperCase() {
        System.out.println("this.name.toUpperCase(Locale.ROOT) = " + this.name.toUpperCase(Locale.ROOT));
    }


}
