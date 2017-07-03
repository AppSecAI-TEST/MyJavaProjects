package com.sample;

/**
 * Created by tharun on 29/6/17.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    public void createLog() {
        Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
        logger.info("hello world logging successful");
    }
}