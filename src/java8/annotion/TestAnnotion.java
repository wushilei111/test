package java8.annotion;


import java.lang.annotation.ElementType.*;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Repeatable(TestAnnotions.class)
@Target({TYPE,FIELD,METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotion {
    String value() default "OK";
}
