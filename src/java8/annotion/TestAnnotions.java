package java8.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE,FIELD,METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotions {
    TestAnnotion[] value();
}
