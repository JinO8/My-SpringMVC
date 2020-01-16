package com.jin.demo.springmvc.annotation;

import java.lang.annotation.*;

/**权限控制，以method为准，如果method上没有加@MySecurity这个注解，那么以class上面的为准，
 * 如果method和class上面都没有加@MySecurity这个注解，表示该资源不能被任何人访问
 * @author wangjin
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MySecurity {
    String[] value();
}
