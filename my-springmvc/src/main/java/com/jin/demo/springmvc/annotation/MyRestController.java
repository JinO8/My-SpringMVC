package com.jin.demo.springmvc.annotation;

import java.lang.annotation.*;

/**控制层（可传入资源访问路径）
 * 如@MyRestController("/demo")
 * @author wangjin
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRestController {
    String value() default "";
}
