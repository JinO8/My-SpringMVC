package com.jin.demo.springmvc;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;


/**
 * 封装handler方法相关的信息
 * @author wangjin
 */
@Data
public class MyHandler {
    /**
     * method.invoke(obj,)
     */
    private Object controller;

    private Method method;
    /**
     * spring中url是支持正则的
     */
    private Pattern pattern;
    /**
     * 参数顺序,是为了进行参数绑定，key是参数名，value代表是第几个参数 <name,2>
     */
    private Map<String, Integer> paramIndexMapping;

    /**
     * 有权限访问该资源的用户（用户名）
     */
    private Set<String> users;

    public MyHandler(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
        this.paramIndexMapping = new HashMap<>();
        this.users = new HashSet<>();
    }

}
