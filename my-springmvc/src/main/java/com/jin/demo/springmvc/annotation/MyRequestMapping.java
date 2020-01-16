package com.jin.demo.springmvc.annotation;

import java.lang.annotation.*;

/**资源访问映射
 * @author wangjin
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestMapping {
    String value() default "";
}
