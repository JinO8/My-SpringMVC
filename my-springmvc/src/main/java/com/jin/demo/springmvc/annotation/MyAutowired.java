package com.jin.demo.springmvc.annotation;

import java.lang.annotation.*;

/**自动注入属性
 * @author wangjin
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAutowired {
    String value() default "";
}
