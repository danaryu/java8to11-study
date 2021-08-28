package hello.danadot.java8to11.etc.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface ChickenContainer {
    // ChickenContainer는 Chicken의 Retention, Target Elements의 Range보다 같거나, 더 넓어야한다!
    ChickenAll[] value();
}
