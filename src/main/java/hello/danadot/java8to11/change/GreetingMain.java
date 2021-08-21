package hello.danadot.java8to11.change;

public class GreetingMain {

    public static void main(String[] args) {
        Greeting greeting = new DefaultGreeting("danadot");
        greeting.printName();
        greeting.printNameUpperCase();

        //Static method 제공
        Greeting.printAnything();
    }

}
