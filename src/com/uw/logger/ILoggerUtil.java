/**  
 * Project Name:uwalgorithm  
 * File Name:LoggerUtil.java  
 * Package Name:com.uw.logger  
 * Date:2019年4月4日下午3:50:59  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.logger;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import com.uw.datatype.BeanCenter;
import com.uw.format.string.StringFormat;

/**
 * ClassName:LoggerUtil <br/>
 * Function: 日志工具接口类. <br/>
 * Reason: 使用异步日志而不使用同步 System/out/print. <br/>
 * Date: 2019年4月4日 下午3:50:59 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public interface ILoggerUtil{
    /**
     * root logger,所有logger的父类
     */
    static Logger ROOTLOGGER= Logger.getRootLogger();

    /**
     * 得到Logger，用于打印日志
     */
    static Logger LOGGER= Logger.getLogger(ILoggerUtil.class);

    /**
     * 
     * stdOut:输出到控制台. <br/>
     * 输出到控制台.<br/>
     * 
     * @author haibing.shen
     * @param isBasic 是否使用基本配置
     * @param pLayout 输出格式
     * @param level 级别
     * @param msg 输出的信息
     * @since JDK 1.6
     */
    default void stdOut(boolean isBasic, String pLayout, Level level, String msg) {
        // 没有调用BasicConfigurator.configure(),PropertyConfigurator.configure()或DOMConfigurator.configure()方法，
        // Log4j会自动加载CLASSPATH下名为log4j.properties的配置文件
        // 把此配置文件改为其他名字,则需要 PropertyConfigurator.configure("classes/my.properties");
        /*
         * if (isBasic) { // BasicConfigurator.configure();// 基本配置,如果执行，就会添加一个默认格式的ConsoleAppender } else { if
         * (StringFormat.isFileName(cfgFileName, "properties")) { PropertyConfigurator.configure("classes/" +
         * cfgFileName); } }
         */

        // PatternLayout p= new PatternLayout("%m");// 给定输出格式
        // %m表示要打印的内容 %n是换行

        // if (BeanCenter.isEmpty(LOGGER.getAllAppenders()) || !LOGGER.getAllAppenders().hasMoreElements()) {//
        // 只绑定一个控制台输出
        // PatternLayout p= !StringCenter.isEmpty(pLayout) ? new PatternLayout(pLayout) : new PatternLayout("%m");
        // ConsoleAppender a= new ConsoleAppender(p, ConsoleAppender.SYSTEM_OUT);// 格式和标准输出设备
        // LOGGER.addAppender(a);
        // }

        // 添加单个控制台输出设备
        Appender.addSingleConsoleAppender(LOGGER, pLayout).setLevel(Level.INFO); // info级别
        // LOGGER.error(msg);
        LOGGER.info(msg);
    }

    /**
     * 
     * stdOut:按指定格式输出到控制台. <br/>
     * 输出到控制台.<br/>
     * 
     * @author haibing.shen
     * @param pLayout 输出格式
     * @param msg 输出内容
     * @since JDK 1.6
     */
    default void stdOut(String pLayout, String msg) {
        stdOut(true, pLayout, Level.INFO, msg);
    }

    /**
     * 
     * stdOut:按指定格式输出到控制台. <br/>
     * 按指定格式输出到控制台.<br/>
     * 
     * @author haibing.shen
     * @param msg 输出内容
     * @since JDK 1.6
     */
    default void stdOut(String msg) {
        stdOut(null, msg);
    }

    /**
     * 
     * fileOut:输出到文件. <br/>
     * 输出到文件.<br/>
     * 
     * @author haibing.shen
     * @param fileName 输出到的文件名
     * @param level 输出级别
     * @param msg 输出的内容
     * @since JDK 1.6
     */
    default void fileOut(String fileName, Level level, String msg) {
        SimpleLayout layout= new SimpleLayout();
        // HTMLLayout layout = new HTMLLayout();
        if (!StringFormat.isFileName(fileName, "txt")) {
            fileName= "out.txt";// 默认文件名
        }
        FileAppender appender= null;
        try {
            // 把输出端配置到文件,比如out.txt
            if (BeanCenter.isEmpty(LOGGER.getAllAppenders()) || !LOGGER.getAllAppenders().hasMoreElements()) {
                appender= new FileAppender(layout, fileName, false);
                LOGGER.addAppender(appender);// 添加输出端
            }
        } catch (Exception e) {
        }

        LOGGER.setLevel(level);// (Level)Level.DEBUG);//覆盖配置文件中的级别
        // LOGGER.debug("debug");
        LOGGER.info(msg);
        // LOGGER.warn("warn");
        // LOGGER.error("error");
        // LOGGER.fatal("fatal");
    }
}
