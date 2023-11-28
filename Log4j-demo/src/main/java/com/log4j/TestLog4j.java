package com.log4j;

import com.sun.prism.impl.BaseContext;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class TestLog4j {

    /**
     * log4j使用案例快速入门
     */
    @Test
    public void testQuick(){
        // 初始化配置信息，在入门案例中暂不使用配置文件，如果注释下面这行代码，log4j框架会抛出警告，不再输出日志信息。
        BasicConfigurator.configure();

        // 获取日志记录器对象
        Logger logger = Logger.getLogger(TestLog4j.class);
        // 输出日志记录
        logger.info("This is an info message.");

        // 日志级别
        logger.fatal("fatal msg");
        // 经常使用的日志级别
        logger.error("error msg");
        logger.warn("warn msg");
        logger.info("info msg");
        logger.debug("debug msg");

        logger.trace("trace msg");

    }

    /**
     * log4j自定义配置文件
     */
    @Test
    public void testCustomizeConfiguration(){

        // 获取日志记录器对象
        Logger logger = Logger.getLogger(TestLog4j.class);
        // 输出日志记录
        logger.info("This is an info message.");

        // 日志级别
        logger.fatal("fatal msg");
        // 经常使用的日志级别
        logger.error("error msg");
        logger.warn("warn msg");
        logger.info("info msg");
        logger.debug("debug msg");

        logger.trace("trace msg");

    }

    /**
     * 使用LogLog类开启log4j内部日志记录开关，便于测试和维护
     *  - 从控制台输出信息中可以看到log4j读取配置信息的过程
     */
    @Test
    public void testLoglogSwitch(){

        // 开启内部日志记录开关
        LogLog.setInternalDebugging(true);

        // 获取日志记录器对象
        Logger logger = Logger.getLogger(TestLog4j.class);
        // 输出日志记录
        logger.info("This is an info message.");

        // 日志级别
        logger.fatal("fatal msg");
        // 经常使用的日志级别
        logger.error("error msg");
        logger.warn("warn msg");
        logger.info("info msg");
        logger.debug("debug msg");

        logger.trace("trace msg");

    }

    /**
     * 测试使用rollingFile类按照日志文件大小进行拆分
     */
    @Test
    public void testRollingFile(){

        // 开启内部日志记录开关
        LogLog.setInternalDebugging(true);

        // 获取日志记录器对象
        Logger logger = Logger.getLogger(TestLog4j.class);
        for (int i = 0; i < 10000; i++) {
            // 输出日志记录
            logger.info("This is an info message.");

            // 日志级别
            logger.fatal("fatal msg");
            // 经常使用的日志级别
            logger.error("error msg");
            logger.warn("warn msg");
            logger.info("info msg");
            logger.debug("debug msg");

            logger.trace("trace msg");
        }

    }

    /**
     * 测试使用DailyRollingFileAppender类按照输出日期进行拆分
     */
    @Test
    public void testDailyRollingFileAppender(){

        // 开启内部日志记录开关
        LogLog.setInternalDebugging(true);

        // 获取日志记录器对象
        Logger logger = Logger.getLogger(TestLog4j.class);
        // 输出日志记录
        logger.info("This is an info message.");

        // 日志级别
        logger.fatal("fatal msg");
        // 经常使用的日志级别
        logger.error("error msg");
        logger.warn("warn msg");
        logger.info("info msg");
        logger.debug("debug msg");

        logger.trace("trace msg");

    }

}
