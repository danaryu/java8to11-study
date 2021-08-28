package hello.danadot.java8to11.etc.annotation;

import java.util.Arrays;

@ChickenAll("양념칰킨")
@ChickenAll("마늘간장")
@ChickenAll("뽀빠ㅇ ㅣ")
public class App {

    public static void main(String[] args) {
        ChickenAll[] chickens = App.class.getAnnotationsByType(ChickenAll.class);
        Arrays.stream(chickens).forEach(chicken -> {
            System.out.println(chicken.value());
        });
    }

/*
    public static void main(String[] args) {
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(chickenAll -> System.out.println("chicken.value() = " + chickenAll.value()));
    }

*/

/*

    public static void main(@ChickenAll String[] args) throws @ChickenAll RuntimeException {
        List<@ChickenAll String> names = Arrays.asList("danadot");
    }

    //Type Parameter Annotation
    static class FeelsLikeChicken<@Chicken T> {

        // return type 전에
        public static <@Chicken C> void print(@ChickenAll C c) {
            // Type Parameter <C> : @Chicken
            // Type C : @ChickenAll
            // Generic
            // Annotation을 여러 Type에 선언할 수 있다.
        }

    }

*/

}
