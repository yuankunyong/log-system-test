package com.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestLogback.class);

    @Test
    public void quickTest(){
        for (int i = 0; i < 10000; i++) {
            // logback打印日志消息，默认是debug级别
            LOGGER.error("error");
            LOGGER.warn("warn");
            LOGGER.info("info");
            LOGGER.debug("debug");
            LOGGER.trace("trace");
        }
    }
}
