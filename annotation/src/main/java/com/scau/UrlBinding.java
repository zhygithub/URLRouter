package com.scau;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZhengHy on 2016/10/6 0006.
 */
@Target(ElementType.TYPE) // on class level
@Retention(RetentionPolicy.CLASS)
public @interface UrlBinding {
    String url();
    String controller();
}
