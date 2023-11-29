package com.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog4jOverSlf4j {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestSlf4j.class);

    /**
     * 测试下面这种情景：当一个公司在一直使用log4j作为日志框架，由于log4j不在适合当前的情况，想要转而
     *      使用slf4j作为新的日志框架，这时为了不改变以前的代码，可以引入log4j-over-slf4j和slf4j-api
     *      依赖的同时，注释掉log4j的依赖，这样就能实现日志框架的替换。
     * 注意：log4j-over-slf4j和slf4j-log4j12不能同时出现，否则会因为死循环抛出栈内存溢出异常。
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
    }
}
