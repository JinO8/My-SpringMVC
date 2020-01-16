package com.jin.demo.springmvc.test.controller;

import com.jin.demo.springmvc.annotation.MyAutowired;
import com.jin.demo.springmvc.annotation.MyRequestMapping;
import com.jin.demo.springmvc.annotation.MyRestController;
import com.jin.demo.springmvc.annotation.MySecurity;
import com.jin.demo.springmvc.test.service.IDemoService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**user1和user2都可以访问这个/demo资源（默认情况）
 * @author wangjin
 */
@MyRestController("/demo")
@MySecurity({"user1","user2"})
@Slf4j
public class DemoController {

    @MyAutowired
    private IDemoService demoService;

    /**user1和user2都可以访问这个/demo/query资源
     * URL: /demo/query?name=user1
     *      /demo/query?name=user2
     */
    @MyRequestMapping("/query")
    public String query(HttpServletRequest request, HttpServletResponse response, String name) {
        log.info(name+"访问: /query 成功");
        return demoService.get(name);
    }

    /**
     * 只有user1可以访问
     * URL: /demo/getUser1?name=user1
     */
    @MyRequestMapping("/getUser1")
    @MySecurity({"user1"})
    public String getUser1(HttpServletRequest request, HttpServletResponse response, String name) {
        log.info(name+"访问: /getUser1 成功");
        return demoService.get(name);
    }

    /**
     * 只有user2可以访问
     * URL: /demo/getUser2?name=user2
     */
    @MyRequestMapping("/getUser2")
    @MySecurity({"user2"})
    public String getUser2(HttpServletRequest request, HttpServletResponse response, String name) {
        log.info(name+"访问: /getUser2 成功");
        return demoService.get(name);
    }
}
