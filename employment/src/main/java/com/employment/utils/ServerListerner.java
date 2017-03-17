package com.employment.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by apple on 2017-3-3.
 */
public class ServerListerner implements ServletContextListener {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    public ServerListerner() {
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
    }

    public void contextInitialized(ServletContextEvent contextEvent) {
        this.logger.info("=================================");
        this.logger.info("系统[{}]启动完成!!!", new Object[]{contextEvent.getServletContext().getServletContextName()});
        this.logger.info("=================================");
    }
}
