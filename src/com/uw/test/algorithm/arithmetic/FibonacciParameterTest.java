/**  
 * Project Name:uwalgorithm  
 * File Name:FibonacciParameterTest.java  
 * Package Name:com.uw.test.algorithm.arithmetic  
 * Date:2019年4月6日下午11:59:07  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.test.algorithm.arithmetic;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.uw.algorithm.arithmetic.Fibonacci;

import junit.framework.Assert;

/**
 * ClassName:FibonacciParameterTest <br/>
 * Function: Fibonacci Test. <br/>
 * Reason: Fibonacci Test. <br/>
 * Date: 2019年4月6日 下午11:59:07 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
@SuppressWarnings("deprecation")
// 指定运行器runner:使用参数化运行器来运行
@RunWith(Parameterized.class)
public class FibonacciParameterTest extends com.uw.test.JunitTest{
    /**
     * 参数
     */
    private int fInput;

    /**
     * 期望值
     */
    private int fExpected;

    /**
     * 
     * data:参数组. <br/>
     * 参数组.<br/>
     * 
     * @author haibing.shen
     * @return 参数组
     * @since JDK 1.6
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 0, 0}, { 1, 1}, { 2, 1}, { 3, 2}, { 4, 3}, { 5, 5}, { 6, 8}});
    }

    /**
     * 
     * Creates a new instance of FibonacciParameterTest.
     * 
     * @param input 参数
     * @param expected 期望值
     */
    public FibonacciParameterTest(int input, int expected){
        fInput= input;
        fExpected= expected;
    }

    /**
     * 
     * test:测试. <br/>
     * 测试.<br/>
     * 
     * @author haibing.shen
     * @since JDK 1.6
     */
    @Test
    public void testC() {
        Assert.assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
