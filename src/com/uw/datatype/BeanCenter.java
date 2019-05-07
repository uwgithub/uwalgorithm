/**  
 * Project Name:uwalgorithm  
 * File Name:BeanCenter.java  
 * Package Name:com.uw.datatype  
 * Date:2019年4月9日下午6:11:58  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.datatype;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * ClassName:BeanCenter <br/>
 * Function: bean对象处理. <br/>
 * Reason: bean对象处理. <br/>
 * Date: 2019年4月9日 下午6:11:58 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class BeanCenter{
    /**
     * 
     * isNull:是否为空对象. <br/>
     * 是否为空对象.<br/>
     * 
     * @author haibing.shen
     * @param object 源对象
     * @return 是否
     * @since JDK 1.6
     */
    public static boolean isNull(Object object) {
        if (null == object || object instanceof JSONObject && ((JSONObject) object).isNullObject()) {
            return true;
        }
        return false;
    }

    /**
     * 
     * isEmpty:检验对象是否为空.. <br/>
     * String 中只有空格.<br/>
     * 在对象中也算空.<br/>
     * 
     * @author haibing.shen
     * @param object 源对象
     * @return 为空返回true,否则false.
     * @since JDK 1.6
     */
    public static boolean isEmpty(Object object) {
        if (isNull(object)
                || object instanceof String
                        && ("".equals(object.toString().trim()) || "null".equalsIgnoreCase(object.toString().trim()))
                || object instanceof StringBuffer && ((StringBuffer) object).length() == 0
                || object instanceof ArrayList && ((List<?>) object).size() == 0
                || object.getClass().isArray() && (Array.getLength(object) == 0
                        || Array.getLength(object) == 1 && Array.get(object, 0) == null)
                || object instanceof Map && ((Map<?,?>) object).size() == 0
                || object instanceof Iterable && !((Iterable<?>) object).iterator().hasNext()) {
            return true;
        } else if (Number.class.isAssignableFrom(object.getClass()) || Date.class.isAssignableFrom(object.getClass()))
            return false;
        else
            return false;
    }

    /**
     * 
     * isNotEmpty:判断对象是否不为空，. <br/>
     * 不为空：返回true.<br/>
     * 为空：返回false.<br/>
     * 
     * @author haibing.shen
     * @param object 源对象
     * @return 是否
     * @since JDK 1.6
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}
