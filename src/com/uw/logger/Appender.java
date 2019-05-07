/**  
 * Project Name:uwalgorithm  
 * File Name:Appender.java  
 * Package Name:com.uw.logger  
 * Date:2019年4月14日下午3:56:36  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.logger;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.uw.datatype.BeanCenter;
import com.uw.datatype.StringCenter;
import com.uw.designpatterns.SinglePattern;
import com.uw.reflect.ReflectCenter;

/**
 * ClassName:Appender <br/>
 * Function: 输出设备. <br/>
 * Reason: 输出设备. <br/>
 * Date: 2019年4月14日 下午3:56:36 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class Appender{
    /**
     * 只打印内容样式
     */
    public static final String CONTENT_PATTERN= "%m";

    /**
     * 换行样式
     */
    public static final String NEWLINE_PATTERN= "%n";

    /**
     * 带换行样式
     */
    public static final String WITHNEWLINE_PATTERN= "%m%n";

    /**
     * 打印样式
     */
    private static Layout consoleLayout= null;

    /**
     * 控制台输出设备
     */
    private static ConsoleAppender consoleAppender= null;

    /**
     * 
     * defPlayout:默认样式: 只打印源字符串. <br/>
     * 默认只打印源字符串.<br/>
     * 
     * @author haibing.shen
     * @param pLayout 源打印样式
     * @return 只打印源字符串的样式
     * @since JDK 1.6
     */
    private static String defPlayout(String pLayout) {
        return StringCenter.isEmpty(pLayout) ? CONTENT_PATTERN : pLayout;// 默认只打印源字符串
    }

    /**
     * 
     * singleLayout:打印样式对象. <br/>
     * 打印样式对象.<br/>
     * 
     * @author haibing.shen
     * @param pLayout 源样式串
     * @return 样式对象
     * @since JDK 1.6
     */
    private static Layout singleLayout(String pLayout) {
        pLayout= defPlayout(pLayout);// 默认只打印源字符串
        consoleLayout= SinglePattern.singleContructor(consoleLayout, PatternLayout.class, pLayout);
        return consoleLayout;
    }

    /**
     * 
     * singelConsoleAppender:单例控制台输出设备. <br/>
     * 单例控制台输出设备.<br/>
     * 
     * @author haibing.shen
     * @param layout 打印样式
     * @return 控制台打印输出设备
     * @since JDK 1.6
     */
    private static ConsoleAppender singleConsoleAppender(Layout layout) {
        consoleAppender= SinglePattern.singleContructor(consoleAppender, ConsoleAppender.class, layout);
        return consoleAppender;
    }

    /**
     * 
     * singelConsoleAppender:单例控制台输出设备. <br/>
     * 单例控制台输出设备.<br/>
     * 
     * @author haibing.shen
     * @param logger 源logger
     * @param pLayout 样式
     * @return 控制台输出设
     * @since JDK 1.6
     */
    @SuppressWarnings("unused")
    private static ConsoleAppender singleConsoleAppender(Logger logger, String pLayout) {
        if (BeanCenter.isEmpty(logger)) {
            return consoleAppender;
        }
        if (isSwitchConsoleLayout(logger, pLayout)) {// 只绑定一个控制台输出
            consoleLayout= singleLayout(pLayout);
            consoleAppender= singleConsoleAppender(consoleLayout);
            if (isInitConsoleLayout(logger)) {// 首次初始化
                logger.addAppender(consoleAppender);// 只添加一个控制台输出设备
            }
        }
        if (isSwitchConsoleLayout(logger, pLayout) && consoleLayout instanceof PatternLayout) {// 根据实际参数更新样式
            PatternLayout patternLayout= ReflectCenter.cast(consoleLayout, PatternLayout.class);
            // String origPLayout= patternLayout.getConversionPattern();
            patternLayout.setConversionPattern(defPlayout(pLayout));
        }

        return consoleAppender;
    }

    /**
     * 
     * isInitConsoleLayout:是否初始化控制台输出设备. <br/>
     * 是否初始化控制台输出设备.<br/>
     * 
     * @author haibing.shen
     * @param logger 日志logger
     * @return 是否
     * @since JDK 1.6
     */
    private static boolean isInitConsoleLayout(Logger logger) {
        if (BeanCenter.isEmpty(logger.getAllAppenders()) || !logger.getAllAppenders().hasMoreElements()
                || BeanCenter.isEmpty(consoleLayout) && BeanCenter.isEmpty(consoleAppender)) {
            return true;
        }
        return false;
    }

    /**
     * 
     * isSwitchLayout:是否需要切换样式. <br/>
     * 首次调用，还是空样式,需要切换.<br/>
     * 样式有变动，则需要切换</br/>
     * 
     * @author haibing.shen
     * @param logger 日志logger
     * @param pLayout 样式
     * @return 是否
     * @since JDK 1.6
     */
    private static boolean isSwitchConsoleLayout(Logger logger, String pLayout) {
        if (isInitConsoleLayout(logger)) {// 初始化控制台输出设备
            return true;
        }
        PatternLayout patternLayout= ReflectCenter.cast(consoleLayout, PatternLayout.class);
        String origPLayout= patternLayout.getConversionPattern();
        return !StringCenter.equals(origPLayout, pLayout);
    }

    /**
     * 
     * appendSingleConsoleAppender:添加单个控制台输出设备. <br/>
     * 添加单个控制台输出设备.<br/>
     * 添加单个控制台输出设备.<br/>
     * 
     * @author haibing.shen
     * @param logger 源日志logger
     * @param pLayout 样式
     * @return 源日志logger
     * @since JDK 1.6
     */
    public static Logger addSingleConsoleAppender(Logger logger, String pLayout) {
        boolean isSyn= isSwitchConsoleLayout(logger, pLayout);
        return ReflectCenter.cast(SinglePattern.synchronizedMethod(isSyn, logger, Appender.class,
                "singleConsoleAppender", ConsoleAppender.class, logger, pLayout), Logger.class);
    }
}
