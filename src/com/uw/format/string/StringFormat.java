/**  
 * Project Name:uwalgorithm  
 * File Name:StringFormat.java  
 * Package Name:com.uw.format.string  
 * Date:2019年4月7日上午10:06:30  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.format.string;

import com.uw.constants.IFormatConstants;
import com.uw.datatype.StringCenter;

/**
 * ClassName:StringFormat <br/>
 * Function: 字符串型数据标准格式. <br/>
 * Reason: 常用字符串型数据的格式. <br/>
 * Date: 2019年4月7日 上午10:06:30 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class StringFormat{
    /**
     * 
     * isFileName:判断.XX文件名是否正确：合法的文件名应该以.XX结尾. <br/>
     * 获取文件名中最后一次出现"."号的位置.<br/>
     * 根据"."号的位置，获取文件的后缀.<br/>
     * 判断"."号位置及文件后缀名.<br/>
     * 
     * @author haibing.shen
     * @param fileName 源文件名
     * @param suffix 后缀
     * @return 是否为文件名
     * @since JDK 1.6
     */
    public static boolean isFileName(String fileName, String suffix) {
        if (StringCenter.isEmpty(fileName) || StringCenter.isEmpty(suffix)) {
            return false;// 不处理空名称或空后缀
        }

        int pointIdx= fileName.lastIndexOf(IFormatConstants.SYMBOLS_POINT); // 获取文件名中最后一次出现"."号的位置
        String suffixOfFileName= fileName.substring(pointIdx + 1, fileName.length()); // 获取文件名中的后缀

        if (pointIdx != -1 && pointIdx != 0 && suffix.equals(suffixOfFileName)) {
            return true; // 判断必须包含"."号，且不能出现在首位，同时后缀名为suffix
        } else {
            return false;
        }
    }

    /**
     * 
     * isEmailAddr:判断邮箱格式是否正确：合法的邮箱名中至少要包含"@", 并且"@"是在"."之前. <br/>
     * 获取文件名中"@"符号的位置.<br/>
     * 获取邮箱中"."号的位置.<br/>
     * 判断必须包含"@"符号，且"@"必须在"."之前.<br/>
     * 
     * @author haibing.shen
     * @param emailAddr 源邮箱地址
     * @return 是否为合法邮箱地址
     * @since JDK 1.6
     */
    public static boolean isEmailAddr(String emailAddr) {
        if (StringCenter.isEmpty(emailAddr)) {
            return false;// 不为空
        }

        int atInd= emailAddr.lastIndexOf(IFormatConstants.SYMBOLS_AT); // 获取邮箱中"@"符号的位置
        int pointInd= emailAddr.indexOf(IFormatConstants.SYMBOLS_POINT); // 获取邮箱中"."号的位置

        // 判断必须包含"@"符号，且"@"必须在"."之前
        if (atInd != -1 && pointInd > atInd) {
            return true;
        } else {
            return false;
        }
    }
}
