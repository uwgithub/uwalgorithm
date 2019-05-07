/**  
 * Project Name:uwalgorithm  
 * File Name:SinglePattern.java  
 * Package Name:com.uw.designpatterns  
 * Date:2019年4月9日下午10:22:48  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.designpatterns;

import com.uw.datatype.BeanCenter;
import com.uw.reflect.ReflectCenter;

/**
 * ClassName:SinglePattern <br/>
 * Function: 单例模式工具类. <br/>
 * Reason: 单例模式传入欲创建单例的类实例变量和实例创建的方法及参数. <br/>
 * Date: 2019年4月9日 下午10:22:48 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class SinglePattern{
    /**
     * 用于创建第三方库类的单实例引用
     */
    // @SuppressWarnings("unused")
    // private static Object instance;

    /**
     * 
     * newInstance:单例创建. <br/>
     * 单例创建.<br/>
     * 第三方类库类的单实例引用.<br/>
     * 
     * @author haibing.shen
     * @param instance 源实例引用变量
     * @param obj 实例创建方法所在的源对象或源class
     * @param metName 实例创建方法名
     * @param metRetClazz 欲创建的实例类型class
     * @param <T> 欲创建的实例类型
     * @param args 实例创建所需要参数
     * @return 实例
     * @since JDK 1.6
     */
    public static <T> T singleInstance(Object instance, Object obj, String metName, Class<T> metRetClazz,
            Object... args) {
        if (BeanCenter.isEmpty(instance)) {
            synchronized (metRetClazz) {
                if (BeanCenter.isEmpty(instance)) {
                    instance= ReflectCenter.invoke(obj, metName, metRetClazz, args);// 使用实例创建方法创建实例
                }
            }
        }
        return ReflectCenter.cast(instance, metRetClazz);// 返回欲创建的实例
    }

    /**
     * 
     * singleInstance:单例创建. <br/>
     * 单例创建.<br/>
     * 
     * @author haibing.shen
     * @param instance instance 源实例引用变量
     * @param <T> 类型
     * @param clazz 类型class
     * @param args 构造函数参数列表
     * @return 实例
     * @since JDK 1.6
     */
    public static <T> T singleContructor(Object instance, Class<T> clazz, Object... args) {
        if (BeanCenter.isEmpty(instance)) {
            synchronized (clazz) {
                if (BeanCenter.isEmpty(instance)) {
                    instance= ReflectCenter.newInstance(clazz, args);// 使用构造方法创建实例
                    // ReflectCenter.setField(clazz, "instance", instance);// 保存实例到源类
                }
            }
        }
        return ReflectCenter.cast(instance, clazz);
    }

    /**
     * 
     * newInstance:方法同步执行. <br/>
     * 方法同步执行.<br/>
     * 第三方类库类的单实例引用.<br/>
     * 
     * @author haibing.shen
     * @param isSyn 是否同步执行
     * @param instance 源实例引用变量
     * @param obj 实例创建方法所在的源对象或源class
     * @param metName 实例创建方法名
     * @param metRetClazz 欲创建的实例类型class
     * @param <T> 欲创建的实例类型
     * @param args 实例创建所需要参数
     * @return 实例
     * @since JDK 1.6
     */
    public static <T> Object synchronizedMethod(boolean isSyn, Object instance, Object obj, String metName,
            Class<T> metRetClazz, Object... args) {
        if (isSyn) {
            synchronized (metRetClazz) {
                if (isSyn) {
                    ReflectCenter.invoke(obj, metName, metRetClazz, args);// 方法同步执行
                }
            }
        }
        return instance;
    }
}
