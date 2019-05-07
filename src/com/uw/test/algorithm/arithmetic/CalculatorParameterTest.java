/**  
 * Project Name:uwalgorithm  
 * File Name:CalculatorTest.java  
 * Package Name:com.uw.test.algorithm.arithmetic  
 * Date:2019年4月6日下午2:51:13  
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

import com.uw.algorithm.arithmetic.Calculator;

import junit.framework.Assert;

/**
 * ClassName:CalculatorTest <br/>
 * Function: Calculator Test. <br/>
 * Reason: Calculator Test. <br/>
 * Date: 2019年4月6日 下午2:51:13 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
@SuppressWarnings("deprecation")
// 指定运行器runner:使用参数化运行器来运行
@RunWith(Parameterized.class)
public class CalculatorParameterTest extends com.uw.test.JunitTest{
    /**
     * @Field 期待的结果值
     */

    private int expected;

    /**
     * @Field 参数1
     */
    private int input1;// 参数1

    /**
     * 参数2
     */
    private int input2;// 参数2

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
     * prepareData:参数化. <br/>
     * 参数化.<br/>
     * 
     * @author haibing.shen
     * @return 参数集合
     * @since JDK 1.6
     */
    @Parameters
    public static Collection<Object[]> prepareData() {
        // 测试数据
        Object[][] objects= { { 3, 1, 2}, { -4, -1, -3}, { 5, 2, 3}, { 4, -4, 8}};
        return Arrays.asList(objects);// 将数组转换成集合返回
    }

    /**
     * 
     * 构造方法 Creates a new instance of CalculatorTest.
     * 
     * @param expected 期望值
     * @param input1 参数1
     * @param input2 参数2
     */
    public CalculatorParameterTest(int expected, int input1, int input2){
        // JUnit会使用准备的测试数据传给构造函数
        this.expected= expected;
        this.input1= input1;
        this.input2= input2;
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
        Assert.assertEquals(this.expected, calculator.add(this.input1, this.input2));
    }
}
