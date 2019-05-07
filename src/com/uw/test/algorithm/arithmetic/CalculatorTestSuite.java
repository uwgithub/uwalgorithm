/**  
 * Project Name:uwalgorithm  
 * File Name:CalculatorTestSuite.java  
 * Package Name:com.uw.test.algorithm.arithmetic  
 * Date:2019年4月6日下午11:39:00  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/
package com.uw.test.algorithm.arithmetic;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * ClassName:CalculatorTestSuite <br/>
 * Function: Calculator TestSuite. <br/>
 * Reason: Calculator TestSuite. <br/>
 * Date: 2019年4月6日 下午11:39:00 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
// @RunWith(Suite.class)
// @SuiteClasses({ CalculatorTestCase.class})
public class CalculatorTestSuite{
    /**
     * 
     * suite:suite方法. <br/>
     * suite方法.<br/>
     * 
     * @author haibing.shen
     * @return Test
     * @since JDK 1.6
     */
    public static Test suite() {
        // 创建TestSuite对象
        TestSuite suite= new TestSuite();
        // 为TestSuite添加一个测试用例集合，参数为：ClasstestClass
        // 通过参数可以知道，其实该参数就是TestCase的子类;整个TestDemo类中的testXXX全部添加到suite
        suite.addTestSuite(CalculatorTestCase.class);

        /*
         * 以addTest方式单独添加 //创建具体的测试用例 Test test = TestSuite.createTest(CalculatorTestCase.class, "testMethod1"); //
         * 添加一个具体的测试用例 suite.addTest(test);
         */

        return suite;
    }
}
