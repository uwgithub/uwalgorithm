/**  
 * Project Name:uwalgorithm  
 * File Name:CalculatorAllTest.java  
 * Package Name:com.uw.test.algorithm.arithmetic  
 * Date:2019年4月6日下午11:22:21  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.test.algorithm.arithmetic;

import org.junit.Test;

import com.uw.algorithm.arithmetic.Calculator;

import junit.framework.Assert;

/**
 * ClassName:CalculatorAllTest <br/>
 * Function: Calculator All Test. <br/>
 * Reason: Calculator All Test. <br/>
 * Date: 2019年4月6日 下午11:22:21 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
@SuppressWarnings("deprecation")
public class CalculatorAllTest extends com.uw.test.JunitTest{

    /**
     * 待测试的类
     */
    private Calculator calculator= null;

    /**
     * 
     * setUp:初始化calculator. <br/>
     * 初始化calculator.<br/>
     * 
     * @author haibing.shen
     * @throws Exception 初始化calculator exception
     * @since JDK 1.6
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        calculator= new Calculator();
    }

    /**
     * 
     * testAdd:测试加法. <br/>
     * 测试加法.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    @Test
    public void testAdd() {
        Assert.assertEquals(5, calculator.add(2, 3));
    }

    /**
     * 
     * testSubtract:测试减法. <br/>
     * 测试减法.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    @Test
    public void testSubtract() {
        Assert.assertEquals(1, calculator.subtract(2, 1));
    }

    /**
     * 
     * testMultiply:测试乘法. <br/>
     * 测试乘法.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    @Test
    public void testMultiply() {
        Assert.assertEquals(6, calculator.multiply(2, 3));
    }

    /**
     * 
     * testDivide:测试除法. <br/>
     * 测试除法.<br/>
     * 
     * @author haibing.shen
     * @throws Exception 异常
     * @since JDK 1.6
     */
    @Test
    public void testDivide() throws Exception {
        Assert.assertEquals(2, calculator.divide(6, 3));
    }
}
