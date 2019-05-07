/**  
 * Project Name:uwalgorithm  
 * File Name:TestDemo.java  
 * Package Name:com.uw.test.algorithm.matrix  
 * Date:2019年4月6日下午1:25:40  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.test.demo;

import com.uw.logger.LoggerUtilImpl;
import com.uw.test.JunitTestCase;

/**
 * ClassName:TestDemo <br/>
 * Function: Test Case Demo. <br/>
 * Reason: Test Case Demo. <br/>
 * Date: 2019年4月6日 下午1:25:40 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class TestDemo extends JunitTestCase{
    /**
     * 
     * testMethod1:test Method1. <br/>
     * test Method1.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    public void testMethod1() {
        // System .out. format("testMethod1 , hashCode = " + hashCode() + "\n");
        LoggerUtilImpl.concurrencyStdOutln("testMethod1 , hashCode = " + hashCode());
    }

    /**
     * 
     * testMethod2:test Method2. <br/>
     * test Method2.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    public void testMethod2() {
        // System. out. format("testMethod2 , hashCode = " + hashCode() + "\n");
        LoggerUtilImpl.concurrencyStdOutln("testMethod2 , hashCode = " + hashCode());
    }
}
