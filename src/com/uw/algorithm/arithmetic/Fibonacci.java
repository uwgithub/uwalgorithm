/**  
 * Project Name:uwalgorithm  
 * File Name:Fibonacci.java  
 * Package Name:com.uw.algorithm.arithmetic  
 * Date:2019年4月6日下午11:46:42  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.algorithm.arithmetic;

/**
 * ClassName:Fibonacci <br/>
 * Function: Fibonacci 数列. <br/>
 * Reason: Fibonacci 数列. <br/>
 * Date: 2019年4月6日 下午11:46:42 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class Fibonacci{
    /**
     * 
     * compute: Fibonacci 数列 第 n列 : 0 1 1 2 3. <br/>
     * Fibonacci 数列 第 n列. <br/>
     * 
     * @author haibing.shen
     * @param n 数列项数
     * @return 第n列的值
     * @since JDK 1.6
     */
    public static int compute(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return compute(n - 1) + compute(n - 2);
        }
    }
}
