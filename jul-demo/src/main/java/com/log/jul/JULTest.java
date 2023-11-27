package com.log.jul;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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

    /**
     * 测试Logger对象的继承关系
     *  结论：
     *      1. logger对象与包名相关，两个logger对象之间的父子关系与包名之间的父子关系相同
     *      2. 子logger对象集成父logger对象，会使用父logger对象的配置
     */
    @Test
    public void testLoggerExtendRelationship(){
        // 使用不同级别的包名获取对应的Logger对象
        Logger childLogger = Logger.getLogger("com.log");
        Logger parentLogger = Logger.getLogger("com");

        // 测试childLogger对象的父对象是否为parentLogger
        System.out.println("Is childLogger the parentLogger's child? -> " + (childLogger.getParent() == parentLogger));

        // 测试顶级包名对应的Logger对象的父对象，输出其name属性 -> 结果为空字符串
        System.out.println("parentLogger's parent : " + parentLogger.getParent() + ", and it's name is : " + parentLogger.getParent().getName());

        // 测试自定义配置父Logger对象的级别为ALL，观察子Logger对象是否输出所有级别日志信息
        // 关闭默认handler
        parentLogger.setUseParentHandlers(false);

        // 创建formatter
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 创建handler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 关联
        consoleHandler.setFormatter(simpleFormatter);
        parentLogger.addHandler(consoleHandler);

        // 设置输出级别
        parentLogger.setLevel(Level.ALL);
        // 以下一行如果不添加，则会输出info级别以上的信息，因为handler默认级别为info，会取logger和handler中的较高级别者作为最后的输出级别
        consoleHandler.setLevel(Level.ALL);

        parentLogger.severe("severe msg");
        parentLogger.warning("warning msg");
        parentLogger.info("info msg");
        parentLogger.config("config msg");
        parentLogger.fine("fine msg");
        parentLogger.finer("finer msg");
        parentLogger.finest("finest msg");
    }


    /**
     * 测试通过配置文件配置日志输出级别
     */
    @Test
    public void testCustomizedConfigurationFile() throws IOException {
        // 加载配置文件
        InputStream ins = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 获取LogManager
        LogManager logManager = LogManager.getLogManager();
        // 读取配置文件
        logManager.readConfiguration(ins);

        // 创建日志记录器（注意：是通过Logger创建，不是通过LogManager创建）
        Logger logger = Logger.getLogger("com.log");
        logger.severe("severe msg");
        logger.warning("warning msg");
        logger.info("info msg");
        logger.config("config msg");
        logger.fine("fine msg");
        logger.finer("finer msg");
        logger.finest("finest msg");
    }
}
