package com.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4j {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestSlf4j.class);

    /**
     * 注意：
     *  1.logback、slf4j-simple日志框架是在slf4j日志门面之后设计的，因此已经遵循slf4j的api，
     *      而JUL和log4j由于是在slf4j之前，因此不能直接绑定，需要通过一个中间层进行绑定。
     *
     */
    @Test
    public void quickTest(){
        // 打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        // 打印变量值
        String name = "yuankunyong";
        Integer age = 24;
        LOGGER.info("name : {}, age : {}", name, age);

        // 打印异常信息
        try{
            int a = 1/0;
        } catch (Exception e) {
            LOGGER.error("程序异常！！！", e);
        }
    }
}
