/**  
 * Project Name:uwalgorithm  
 * File Name:UWTest.java  
 * Package Name:com.uw.test  
 * Date:2019年4月6日下午10:29:46  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.uw.logger.LoggerUtilImpl;

/**
 * ClassName:UWTest <br/>
 * Function: UW Test. <br/>
 * Reason: UW Test. <br/>
 * Date: 2019年4月6日 下午10:29:46 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class JunitTest{

    /**
     * 
     * setUpBeforeClass:初始化工作之前. <br/>
     * 初始化工作之前.<br/>
     * 
     * @author haibing.shen
     * @throws Exception 初始化工作之前的exception
     * @since JDK 1.6
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // System. out. format("before class..\n");
        LoggerUtilImpl.concurrencyStdOutln("before class..");
    }

    /**
     * 
     * setUp:初始化工作. <br/>
     * 初始化工作.<br/>
     * 
     * @author haibing.shen
     * @throws Exception 初始化工作exception
     * @since JDK 1.6
     */
    @Before
    public void setUp() throws Exception {
        // System. out. format("before..\n");
        LoggerUtilImpl.concurrencyStdOutln("before..");
    }

    /**
     * 父类test方法是个空的，不必要;只要有test方法就会创建实例 test:test 方法. <br/>
     * test 方法.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    // @Test
    // public void test() {
    // LoggerUtilImpl.concurrencyStdOutln("testing..");
    // }

    /**
     * 
     * tearDown:收尾工作. <br/>
     * 收尾工作.<br/>
     * 
     * @author haibing.shen
     * @throws Exception 收尾工作exception
     * @since JDK 1.6
     */
    @After
    public void tearDown() throws Exception {
        // System. out. format("after..\n");
        LoggerUtilImpl.concurrencyStdOutln("after..");
    }

    /**
     * 
     * tearDownAfterClass:收尾工作后. <br/>
     * 收尾工作后.<br/>
     * 
     * @author haibing.shen
     * @throws Exception 收尾工作后exception
     * @since JDK 1.6
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // System. out. format("after class..\n");
        LoggerUtilImpl.concurrencyStdOutln("after class..");
    }
}
