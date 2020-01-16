package com.jin.demo.springmvc.test.service;

import com.jin.demo.springmvc.annotation.MyService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangjin
 */
@MyService("demoService")
@Slf4j
public class DemoServiceImpl implements IDemoService {
    @Override
    public String get(String name) {
        log.info("service 实现类中的name参数：" + name);
        return "Hi,"+name;
    }
}
