package hello.danadot.java8to11.functional;

import java.util.function.Function;

public class FunctionalInterface2 implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
}
