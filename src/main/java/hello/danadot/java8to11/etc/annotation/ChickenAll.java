package hello.danadot.java8to11.etc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
//@Target(ElementType.TYPE_USE) Type을 사용하는 모든 곳에 사용 가능!
public @interface ChickenAll {
    String value();
}
