package com.spring.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName: ServletListener
 * =================================================
 * @Description: 注解版的listener
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @CreateDate: 2019/12/5 22:45
 * @Version: V1.0
 */
@WebListener
public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("WebListener..........................");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
