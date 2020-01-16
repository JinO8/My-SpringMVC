package com.jin.demo.springmvc.annotation;

import java.lang.annotation.*;

/**Service层的注解
 * @author wangjin
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyService {
    String value() default "";
}
