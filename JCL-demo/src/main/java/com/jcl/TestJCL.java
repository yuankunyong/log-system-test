package com.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestJCL {

    @Test
    public void quickTest(){
        // 获取日志记录器对象
        Log logger = LogFactory.getLog(TestJCL.class);
        // 打印日志
        logger.info("This is an info message.");
    }

}
