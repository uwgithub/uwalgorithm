/**  
 * Project Name:uwalgorithm  
 * File Name:MatrixArithmeticParameterTest.java  
 * Package Name:com.uw.test.algorithm.matrix  
 * Date:2019年4月7日上午12:27:17  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.test.algorithm.matrix;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.uw.algorithm.matrix.MatrixArithmetic;
import com.uw.logger.LoggerUtilImpl;

/**
 * ClassName:MatrixArithmeticParameterTest <br/>
 * Function: Matrix Arithmetic Parameter Test. <br/>
 * Reason: Matrix Arithmetic Parameter Test. <br/>
 * Date: 2019年4月7日 上午12:27:17 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
// 指定运行器runner:使用参数化运行器来运行
@RunWith(Parameterized.class)
public class MatrixArithmeticParameterTest extends com.uw.test.JunitTest{

    /**
     * 参数n,矩阵维度
     */
    private int nInput;

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
    public static Collection<Object> data() {
        return Arrays.asList(new Object[] { 3, 5});
    }

    /**
     * 
     * Creates a new instance of MatrixArithmeticParameterTest.
     * 
     * @param input 参数
     */
    public MatrixArithmeticParameterTest(int input){
        nInput= input;
    }

    /**
     * 
     * genMatrix:生成n维矩阵. <br/>
     * 生成行类数一致的方阵.<br/>
     * 
     * @author haibing.shen
     * @param n 矩阵维度
     * @return n维矩阵
     * @since JDK 1.6
     */
    public static int[][] genMatrix(int n) {
        int[][] matrix= new int[n][n];
        int p= 1;
        for (int i= 0; i < n; i++) {
            for (int j= 0; j < n; j++) {
                matrix[i][j]= p++;
            }
        }

        return matrix;
    }

    /**
     * 
     * polishSpace:根据维度补齐空格. <br/>
     * 有几维度就占几个位置宽，不够就补齐空格.<br/>
     * 
     * @author haibing.shen
     * @param n 维度n
     * @param num 矩阵中要补齐空格的元素
     * @return 补齐空格后的元素
     * @since JDK 1.6
     */
    public static String polishSpace(int n, int num) {
        int nLen= String.valueOf(n).length();// 维度对应位数
        String sNum= String.valueOf(num);
        int numLen= sNum.length();// 数的位数
        for (int i= 0; i < nLen - numLen; i++) {
            sNum= " " + sNum;// 前补齐空格
        }
        return sNum;
    }

    /**
     * 
     * printMatrix:打印矩阵. <br/>
     * 每个元素都占固定宽度的位置.<br/>
     * 
     * @author haibing.shen
     * @param matrix 源矩阵
     * @since JDK 1.6
     */
    public static void printMatrix(int[][] matrix) {
        int n= matrix.length;
        int max= n * n;
        for (int i= 0; i < n; i++) {
            for (int j= 0; j < n; j++) {
                // if (j > 0) {
                // // System. out. format("%5s", "");// printf
                // LoggerUtilImpl.concurrencyStdOut(20);
                // }
                // System. out. format(polishSpace(max, matrix[i][j]));// 补齐空格
                // LoggerUtilImpl.concurrencyStdOut(polishSpace(max, matrix[i][j]), 20);
                LoggerUtilImpl.concurrencyStdOut(polishSpace(max, matrix[i][j]), 5);
            }
            // System. out. format("\n");// 打印换行符 println
            LoggerUtilImpl.concurrencyStdOutln();
        }
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
        int[][] matrix= MatrixArithmeticParameterTest.genMatrix(nInput);// 生成n行列的矩阵 // System. out. format("旋转前:\n");
        LoggerUtilImpl.concurrencyStdOutln("旋转前:");
        MatrixArithmeticParameterTest.printMatrix(matrix);// 打印矩阵

        // 测试矩阵旋转
        MatrixArithmetic.roTateMatrix(matrix);// 旋转矩阵 // System. out. format("旋转后:\n");
        LoggerUtilImpl.concurrencyStdOutln("旋转后:");
        MatrixArithmeticParameterTest.printMatrix(matrix);// 打印矩阵

    }
}
