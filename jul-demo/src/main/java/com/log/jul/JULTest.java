package com.log.jul;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

public class JULTest {
    @Test
    public void testJul(){
        Logger logger = Logger.getLogger("com.log.jul.JULTest");
        logger.info("hello jul...");

        logger.log(Level.INFO, "info msg");

        // 通过占位符输出变量信息
        String userName = "yuankunyong";
        int age = 25;
        logger.log(Level.INFO, "用户信息：{0}对的年龄为：{1}", new Object[]{userName, age});

    }

    @Test
    public void testLogLevel(){
        Logger logger = Logger.getLogger("com.log.jul.JULTest");
        logger.severe("severe msg");
        logger.warning("warning msg");
        logger.info("info msg");
        logger.config("config msg");
        logger.fine("fine msg");
        logger.finer("finer msg");
        logger.finest("finest msg");
    }

    /**
     * 自定义日志级别
     */
    @Test
    public void testLogConfig() throws IOException {
        Logger logger = Logger.getLogger("com.log.jul.JULTest");

        // 关闭默认配置
        logger.setUseParentHandlers(false);

        // 自定义日志配置
        // 定义简单格式化对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // 定义ConsoleHandler处理器对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        // 配置具体的日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 定义FileHandler处理器对象
        // TODO: 注意fileHandler会创建文件，但是不会创建文件夹，因此要确保路径上的文件夹是存在的
        FileHandler fileHandler = new FileHandler("./logs/jul.log");

        // 关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        // TODO:下面这行代码会对结果有影响吗？
        fileHandler.setLevel(Level.ALL);

        logger.severe("severe msg");
        logger.warning("warning msg");
        logger.info("info msg");
        logger.config("config msg");
        logger.fine("fine msg");
        logger.finer("finer msg");
        logger.finest("finest msg");
    }
}
