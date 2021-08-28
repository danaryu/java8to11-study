package hello.danadot.java8to11.etc.annotation;

import java.lang.annotation.*;

// 언제까지 유지할 것인가..? Retention
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_PARAMETER)
public @interface Chicken {
    //String value();
}
