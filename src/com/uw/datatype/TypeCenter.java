/**  
 * Project Name:uwalgorithm  
 * File Name:TypeCenter.java  
 * Package Name:com.uw.datatype  
 * Date:2019年4月4日上午8:19:54  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.datatype;

/**
 * ClassName:TypeCenter <br/>
 * Function: 类型转换. <br/>
 * Reason: 基本数据类型和字符串的互转. <br/>
 * Date: 2019年4月4日 上午8:19:54 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class TypeCenter {
    /**
     * 
     * stringOf:整型数字对应的字符串. <br/>
     * 数字通过字符串处理.<br/>
     * 
     * @author haibing.shen
     * @param num 整型数字
     * @return 数字的字符串
     * @since JDK 1.6
     */
    public static String stringOf(int num) {
        return String.valueOf(num);
    }
}
