/**  
 * Project Name:uwalgorithm  
 * File Name:MatrixArithmetic.java  
 * Package Name:com.uw.algorithm.matrix  
 * Date:2019年4月4日上午8:13:35  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.algorithm.matrix;

/**
 * ClassName:MatrixArithmetic <br/>
 * Function: 矩阵运算. <br/>
 * Reason: 矩阵旋转等. <br/>
 * Date: 2019年4月4日 上午8:13:35 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class MatrixArithmetic {
    /**
     * 
     * roTateMatrix:顺时针旋转90度. <br/>
     * 旋转90度.<br/>
     * 
     * @author haibing.shen
     * @param matrix 源矩阵
     * @since JDK 1.6
     */
    public static void roTateMatrix(int[][] matrix) {
        int n = matrix.length;
        int rt = 0;
        for (int i = 0; i < n / 2; i++) { // 行号;一半圈数，奇数取整，中心点不动.
            for (int j = i; j < n - 2 * i - 1; j++) {// 列号;第i圈的待移动元素，为除i-1圈元素之外;处理左角元素同时处理了右角上的元素(所以-1),中间元素的在各边上
                rt = matrix[i][j]; // 暂存左列上一元素
                matrix[i][j] = matrix[n - 1 - j][i];// 将下边元素转到左边;行号->列号,行号和n-1
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];// 右边元素转到下边;行号->列号,行号和n-1
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];// 上边元素转到右边;行号->列号,行号和n-1
                matrix[j][n - 1 - i] = rt;// 暂存的左列元素写到上边
            }
        }
    }
}
