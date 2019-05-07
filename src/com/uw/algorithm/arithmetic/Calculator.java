/**  
 * Project Name:uwalgorithm  
 * File Name:Calculator.java  
 * Package Name:com.uw.algorithm.arithmetic  
 * Date:2019年4月6日下午2:13:01  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/
package com.uw.algorithm.arithmetic;

/**
 * ClassName:Calculator <br/>
 * Function: Calculator. <br/>
 * Reason: Calculator. <br/>
 * Date: 2019年4月6日 下午2:13:01 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class Calculator{
    /**
     * 
     * add:加法运算. <br/>
     * 加法.<br/>
     * 
     * @author haibing.shen
     * @param a 操作数1
     * @param b 操作数2
     * @return 两操作数之和
     * @since JDK 1.6
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 
     * subtract:减法运算. <br/>
     * 减法.<br/>
     * 
     * @author haibing.shen
     * @param a 操作数1
     * @param b 操作数2
     * @return 两操作数之差
     * @since JDK 1.6
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * 
     * multiply:乘法运算. <br/>
     * 乘法.<br/>
     * 
     * @author haibing.shen
     * @param a 操作数1
     * @param b 操作数2
     * @return 两操作数之积
     * @since JDK 1.6
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * 
     * divide:除法运算. <br/>
     * 除法.<br/>
     * 
     * @author haibing.shen
     * @param a 操作数1
     * @param b 操作数2
     * @return 两操作数之商
     * @throws Exception 除数为0的异常
     * @since JDK 1.6
     */
    public int divide(int a, int b) throws Exception {
        if (0 == b) {
            throw new Exception("除数不能为0");
        }
        return a / b;
    }

}
