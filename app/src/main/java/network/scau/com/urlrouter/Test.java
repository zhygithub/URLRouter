package network.scau.com.urlrouter;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2016/9/21 0021.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String name() default "";
    int age() default 10;
}
