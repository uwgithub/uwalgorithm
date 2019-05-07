/**  
 * Project Name:uwalgorithm  
 * File Name:UWTestCase.java  
 * Package Name:com.uw.test  
 * Date:2019年4月6日下午11:27:45  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.test;

import com.uw.logger.LoggerUtilImpl;

import junit.framework.TestCase;

/**
 * ClassName:UWTestCase <br/>
 * Function: UW Test Case. <br/>
 * Reason: UW Test Case. <br/>
 * Date: 2019年4月6日 下午11:27:45 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class JunitTestCase extends TestCase{
    /**
     * 
     * 初始化工作.
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // System. out. format("setUp , hashCode = " + hashCode() + "\n");
        LoggerUtilImpl.concurrencyStdOutln("setUp , hashCode = " + hashCode());
    }

    /**
     * 
     * 收尾工作
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        // System. out. format("tearDown,hashCode = " + hashCode() + "\n");
        LoggerUtilImpl.concurrencyStdOutln("tearDown,hashCode = " + hashCode());
    }
}
