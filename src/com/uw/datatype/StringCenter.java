/**  
 * Project Name:uwalgorithm  
 * File Name:StringCenter.java  
 * Package Name:com.uw.datatype  
 * Date:2019年4月7日上午9:51:08  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.datatype;

import java.util.List;

/**
 * ClassName:StringCenter <br/>
 * Function: String处理中心. <br/>
 * Reason: 字符串相关辅助性处理. <br/>
 * Date: 2019年4月7日 上午9:51:08 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class StringCenter{
    /**
     * 
     * isNull:字符串是否为null. <br/>
     * null字符串.<br/>
     * 
     * @author haibing.shen
     * @param orig 源字符串
     * @return 返回是/否
     * @since JDK 1.6
     */
    public static boolean isNull(String orig) {
        return orig == null;
    }

    /**
     * 
     * isEmpty:字符串是否为空. <br/>
     * null或长度为0.<br/>
     * 
     * @author haibing.shen
     * @param orig 源字符串
     * @return 返回是/否
     * @since JDK 1.6
     */
    public static boolean isEmpty(String orig) {
        return isNull(orig) || orig.trim().isEmpty();
    }

    /**
     * 
     * getRawValue:求string值. <br/>
     * 求string值.<br/>
     * 
     * @author haibing.shen
     * @param origValue 源值
     * @param defaultValues 默认值
     * @return string值
     * @since JDK 1.6
     */
    public static String getRawValue(Object origValue, String... defaultValues) {
        return BeanCenter.isNotEmpty(origValue) ? origValue.toString()
                : (BeanCenter.isNotEmpty(defaultValues) ? defaultValues[0] : "");
    }

    /**
     * 
     * contain:列表中成员大于等于包含给定的string. <br/>
     * 列表中成员大于等于包含给定的string.<br/>
     * 
     * @author haibing.shen
     * @param orig 源string
     * @param dest 目标string
     * @param isAsc 大于等于
     * @return 是否
     * @since JDK 1.6
     */
    public static boolean contain(List<String> orig, String dest, boolean... isAsc) {
        if (BeanCenter.isEmpty(orig)) {
            return false;
        }
        boolean isAsc1= true;
        if (BeanCenter.isNotEmpty(isAsc)) {
            isAsc1= isAsc[0];
        }
        for (String it : orig) {
            if (isAsc1 && it.contains(dest) || !isAsc1 && dest.contains(it)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * isLowerCase:判断给定字符是否小写. <br/>
     * 判断给定字符是否小写.<br/>
     * 
     * @author haibing.shen
     * @param ch 源字符
     * @return 是否小写
     * @since JDK 1.6
     */
    public static boolean isLowerCase(char ch) {
        return ch >= 97 && ch <= 122;
    }

    /**
     * 
     * concat:字符串连接. <br/>
     * 字符串连接.<br/>
     * 
     * @author haibing.shen
     * @param orig 源串
     * @param dest 目标串
     * @param regex 正则表达式
     * @return 连接后的串
     * @since JDK 1.6
     */
    public static String concat(String orig, String dest, String... regex) {
        return concating(orig, dest, regex).toString();
    }

    /**
     * 
     * concating:xx. <br/>
     * xx.<br/>
     * 
     * @author haibing.shen
     * @param orig 源串
     * @param dest 目标串
     * @param regex 正则表达式
     * @return 连接后的串
     * @since JDK 1.6
     */
    public static StringBuffer concating(String orig, String dest, String... regex) {
        orig= getRawValue(orig);// isEmpty(orig) ? "" : orig;
        dest= getRawValue(dest);// isEmpty(dest) ? "" : dest;
        String regex1= BeanCenter.isNotEmpty(regex) ? regex[regex.length - 1] : "";
        StringBuffer sb= new StringBuffer();
        sb.append(orig);
        sb.append((isEmpty(orig) || isEmpty(dest)) ? "" : regex1);
        sb.append(dest);
        if (BeanCenter.isNotEmpty(regex) && regex.length > 1) {
            for (int i= 0; i < regex.length - 1; i++) {
                sb= concating(sb, regex[i], regex1);
            }
        }
        return sb;
    }

    /**
     * 
     * concating:连接. <br/>
     * 连接.<br/>
     * 
     * @author haibing.shen
     * @param sb 源stringbuffer
     * @param dest 目标串
     * @param regex 正则表达式
     * @return 连接后的stringbuffer
     * @since JDK 1.6
     */
    public static StringBuffer concating(StringBuffer sb, Object dest, String... regex) {
        // orig = isEmpty(orig) ? "" : orig;
        sb= BeanCenter.isEmpty(sb) ? new StringBuffer() : sb;

        return sb.append(concat("", getRawValue(dest), regex));

        /*
         * if(BaseUtils.isEmpty(dest)){ return sb; }
         * 
         * String dest1 = getRawValue(dest);//空值处理 //dest = isEmpty(dest) ? "" : dest; String regex1 =
         * BaseUtils.isNotEmpty(regex) && BaseUtils.isNotEmpty(sb) ? regex[0] : ""; //sb.append(orig);
         * sb.append(regex1); sb.append(dest1); return sb;
         */
    }

    /**
     * 
     * appendln:添加换行. <br/>
     * 添加换行.<br/>
     * 
     * @author haibing.shen
     * @param orig 源串
     * @return 带上换行符的串
     * @since JDK 1.6
     */
    public static String appendln(String orig) {
        return concat(orig, "\n");
    }

    /**
     * 
     * equals:比较两个字符串是否相同. <br/>
     * 比较两个字符串是否相同.<br/>
     * 
     * @author haibing.shen
     * @param orig 源串
     * @param dest 目标串
     * @return 是/否
     * @since JDK 1.6
     */
    public static boolean equals(String orig, String dest) {
        orig= isNull(orig) ? "" : orig;
        dest= isNull(dest) ? "" : dest;
        return orig.equals(dest);
    }
}
