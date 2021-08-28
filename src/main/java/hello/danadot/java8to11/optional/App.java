package hello.danadot.java8to11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "SpringBoot", true));
        springClasses.add(new OnlineClass(5, "Rest Api development", false));

        // 있을 수도 있고..
        Optional<OnlineClass> optional = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("Spring"))
                .findFirst();

        // 만약에 Optional값이 비어있다면?... get을 사용하는 것은, 비어있을 수도 있기 때문에 좋지 않음
       // OnlineClass onlineClass = class1.get();
        //System.out.println(onlineClass.getTitle());

        // 있을 때만...
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        // 있으면 꺼내오고, 없을때는
        OnlineClass onlineClass = optional.orElse(createNewJpaClasses());
        System.out.println("onlineClass = " + onlineClass.getTitle());

        // lazy
        OnlineClass onlineClass1 = optional.orElseGet(App::createNewJpaClasses);
        System.out.println("onlineClass1 = " + onlineClass1);

        // 대안이 없는 경우, exception 처리
        OnlineClass onlineClass2 = optional.orElseThrow(IllegalStateException::new);
        System.out.println("onlineClass2 = " + onlineClass2);
        
        // filter에 해당이 되면 나온다!
        Optional<OnlineClass> onlineClass3 = optional.filter(oc -> oc.getId() > 10);
        System.out.println("onlineClass3 = " + onlineClass3);
        System.out.println("onlineClass3.isEmpty() = " + onlineClass3.isEmpty());

        // map
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println("integer = " + integer);
        System.out.println("integer.isPresent() = " + integer.isPresent());

        // map으로 꺼내는 타입 자체가 Optional 인 경우! --> Progress
        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        Progress progress2 = progress1.orElseThrow();

        // 위의 경우 처럼 return타입이 Optional 인 경우 Optional FlatMap
        Optional<Progress> progress3 = optional.flatMap(OnlineClass::getProgress);
    System.out.println("progress3 = " + progress3);

        // Stream에서 쓰는 FlatMap
        // input이 하나지만, output이 여러개인..?

    }

    private static OnlineClass createNewJpaClasses() {
        System.out.println("creating new online Class");
        return new OnlineClass(10, "new Class JPA", false);

    }
}
