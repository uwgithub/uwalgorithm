/**  
 * Project Name:uwalgorithm  
 * File Name:LoggerUtilImpl.java  
 * Package Name:com.uw.logger  
 * Date:2019年4月7日下午1:43:50  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.logger;

import com.uw.concurrency.ConcurrencyCenter;
import com.uw.datatype.BeanCenter;
import com.uw.datatype.StringCenter;
import com.uw.designpatterns.SinglePattern;

/**
 * ClassName:LoggerUtilImpl <br/>
 * Function: 日志输出应用. <br/>
 * Reason: 日志输出应用. <br/>
 * Date: 2019年4月7日 下午1:43:50 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class LoggerUtilImpl implements ILoggerUtil{
    /**
     * 当前类的实例
     */
    private static LoggerUtilImpl instance= null;

    /**
     * 
     * Creates a new instance of LoggerUtilImpl.
     *
     */
    private LoggerUtilImpl(){

    }

    /**
     * 
     * getInstance:当前类单例. <br/>
     * 当前类单例.<br/>
     * 
     * @author haibing.shen
     * @return 单例
     * @since JDK 1.6
     */
    public static LoggerUtilImpl getSingleInstance() {
        instance= SinglePattern.singleContructor(instance, LoggerUtilImpl.class);
        return instance;
    }

    /**
     * 
     * stdOut:按固定宽度，输出到控制台. <br/>
     * 按固定宽度，输出到控制台.<br/>
     * 
     * @author haibing.shen
     * @param msg 待输出内容
     * @param width 固定宽度
     * @param pLayout 其他样式
     * @since JDK 1.6
     */
    public void stdOut(String msg, Integer width, String... pLayout) {
        // String pLayout= "%" + width + "c";
        String pLayout1= StringCenter.concat(StringCenter.concat("%", String.valueOf(width)), "m");
        pLayout1= (BeanCenter.isNull(pLayout) || pLayout.length == 0) ? pLayout1
                : StringCenter.concat(pLayout1, pLayout[0]);
        stdOut(pLayout1, msg);
    }

    /**
     * 
     * 输出到控制台.
     * 
     * @param msg 待输出内容
     * @since JDK 1.6
     * 
     */
    public void stdOut(String msg) {
        stdOut(null, msg);
    }

    /**
     * 
     * concurrencyStdOut:并发情形下输出到控制台. <br/>
     * 并发情形下输出到控制台.<br/>
     * 
     * @author haibing.shen
     * @param msg 待输出的内容
     * @since JDK 1.6
     */
    public static void concurrencyStdOut(String msg) {
        ConcurrencyCenter.concurrencyHandler(getSingleInstance(), "stdOut", null, msg);
    }

    /**
     * 
     * concurrencyStdOutln: 并发情形下输出到控制台并换行. <br/>
     * 并发情形下输出到控制台并换行.<br/>
     * 
     * @author haibing.shen
     * @param msg 打印的内容
     * @since JDK 1.6
     */
    public static void concurrencyStdOutln(String msg) {
        ConcurrencyCenter.concurrencyHandler(getSingleInstance(), "stdOut", null, Appender.WITHNEWLINE_PATTERN, msg);
    }

    /**
     * 
     * concurrencyStdOutln:打印换行. <br/>
     * 打印换行.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    public static void concurrencyStdOutln() {
        concurrencyStdOutln("");
    }

    /**
     * 
     * concurrencyStdOut:并发情形下输出到控制台. <br/>
     * 并发情形下输出到控制台.<br/>
     * 
     * @author haibing.shen
     * @param msg 待输出内容
     * @param width 固定宽度
     * @since JDK 1.6
     */
    public static void concurrencyStdOut(String msg, Integer width) {
        ConcurrencyCenter.concurrencyHandler(getSingleInstance(), "stdOut", null, msg, width, new String[] {});
    }

    /**
     * 
     * concurrencyStdOut:打印指定长度空格. <br/>
     * 打印指定长度空格.<br/>
     * 
     * @author haibing.shen
     * @param width 指定宽度
     * @since JDK 1.6
     */
    public static void concurrencyStdOut(Integer width) {
        concurrencyStdOut("", width);
    }

    /**
     * 
     * concurrencyStdOutln:并发情形下输出到控制台并打印换行. <br/>
     * 并发情形下输出到控制台并打印换行.<br/>
     * 
     * @author haibing.shen
     * @param msg 待输出内容
     * @param width 固定宽度
     * @since JDK 1.6
     */
    public static void concurrencyStdOutln(String msg, Integer width) {
        ConcurrencyCenter.concurrencyHandler(getSingleInstance(), "stdOut", null, msg, width,
                new String[] { Appender.NEWLINE_PATTERN});
    }
}
