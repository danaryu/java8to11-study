package hello.danadot.java8to11.optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalMain {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "Spring boot", true));
        springClasses.add(new OnlineClass(2, "Spring data jpa", true));
        springClasses.add(new OnlineClass(3, "Spring mvc", true));
        springClasses.add(new OnlineClass(4, "Spring core", true));
        springClasses.add(new OnlineClass(5, "RestApi development", true));

        OnlineClass spring_boot = new OnlineClass(1, "Spring boot", true);

        //Collection, Map, Stream Array. Optional은 Optional로 감싸지 말 것.....

    }

}
