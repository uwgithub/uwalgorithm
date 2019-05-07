/**  
 * Project Name:uwalgorithm  
 * File Name:ReflectCenter.java  
 * Package Name:com.uw.reflect  
 * Date:2019年4月9日下午6:02:01  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/
package com.uw.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.uw.datatype.BeanCenter;
import com.uw.datatype.StringCenter;

//import com.sany.upgrade.utils.StringUtilities;

/**
 * ClassName:ReflectCenter <br/>
 * Function: 反射管理. <br/>
 * Reason: 反射管理. <br/>
 * Date: 2019年4月9日 下午6:02:01 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class ReflectCenter implements InvocationHandler{
    /**
     * 特定类型
     */
    private static final List<String> SEPCIALCLASSNAME= Arrays
            .asList(new String[] { "byte", "[Ljava.lang.Object;", "["});

    /**
     * 
     * forName:由name得到class对象 . <br/>
     * String.class.getName() "java.lang.String".<br/>
     * byte.class.getName() "byte".<br/>
     * new Object[3]).getClass().getName() "[Ljava.lang.Object;".<br/>
     * (new Integer[3][4][5][6][7][8][9]).getClass().getName() "[[[[[[[I".<br/>
     * 
     * @author haibing.shen
     * @param clzName 源类名称
     * @return 类型
     * @since JDK 1.6
     */
    public static Class<?> forName(String clzName) {
        try {
            if (!StringCenter.contain(SEPCIALCLASSNAME, clzName, false) && clzName.indexOf(".") == -1
                    && !StringCenter.isLowerCase(clzName.charAt(0))) {
                clzName= "java.lang." + clzName;
            }
            Class<?> clz= Class.forName(clzName);
            return clz;
        } catch (Exception e) {
            // log.error(ExceptionUtils.getFullStackTrace(e));
            // throw new BusinessException("获取class失败，异常为：" + e.getMessage());
            return null;
        }
    }

    /**
     * 
     * newInstance:实例化对象. <br/>
     * 实例化对象.<br/>
     * 
     * @author haibing.shen
     * @param <T> 源类型
     * @param args 传给构造函数的参数列表
     * @param clazz 源class
     * @return 返回 T 类型
     * @since JDK 1.6
     */
    public static <T> T newInstance(Class<T> clazz, Object... args) {
        try {
            boolean hasArgs= BeanCenter.isNotEmpty(args);
            Constructor<?> constructor= hasArgs ? getConstructor(clazz, new Class<?>[args.length], 0, getClazzs(args))
                    : clazz.getDeclaredConstructor();
            // Constructor<?> constructor= hasArgs ? clazz.getDeclaredConstructor(args[0].getClass().getSuperclass())
            // : clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            @SuppressWarnings("unchecked")
            T object= hasArgs ? (T) constructor.newInstance(args[0]) // 带参函数
                    : (T) constructor.newInstance();// 无参函数
            // @SuppressWarnings("unchecked")
            // T object= (T) forName(clazz.getName()).newInstance();// 默认构造器
            // Class<?> componentClass = Class.forName("com.tcpan.es.component." + componentName);
            // Constructor<?> constructor = componentClass.getDeclaredConstructor(String.class);
            // return (Component) constructor.newInstance("hi");

            return object;
        } catch (Exception e) {
            // log.error(ExceptionUtils.getFullStackTrace(e));
            // throw new BusinessException("实例化对象失败，异常为：" + e.getMessage());
            return null;
        }
    }

    /**
     * 
     * newIFInstance:接口实例化. <br/>
     * 接口实例化.<br/>
     * 
     * @author haibing.shen
     * @param interfaces 接口Class
     * @return 接口对应的实例
     * @since JDK 1.6
     */
    public static Object newIFInstance(Class<?>[] interfaces) {
        return Proxy.newProxyInstance(ReflectCenter.class.getClassLoader(), interfaces, new ReflectCenter());
    }

    /**
     * 
     * cast:强制转换成给定类型的object. <br/>
     * 强制转换成给定类型的object.<br/>
     * 
     * @author haibing.shen
     * @param object 源对象
     * @param clazz 要转换的class
     * @param <T> 要转换成的类型
     * @return 要转换得到的类型
     * @since JDK 1.6
     */
    public static <T> T cast(Object object, Class<T> clazz) {
        if (BeanCenter.isEmpty(object) || BeanCenter.isEmpty(clazz)) {
            return null;
        }
        try {
            return clazz.cast(object);
        } catch (ClassCastException ex) {
            // log.error(ExceptionUtils.getFullStackTrace(ex));
            return null;
        }
    }

    /**
     * 
     * cast:强制转换成给定类型的object. <br/>
     * 强制转换成给定类型的object.<br/>
     * 
     * @author haibing.shen
     * @param map 源map
     * @param key 源map中key
     * @param <T> 要转换成的类型
     * @param clazz 欲转换的class
     * @return 转换得到的结果类型
     * @since JDK 1.6
     */
    public static <T> T cast(Map<?,?> map, Object key, Class<T> clazz) {
        if (BeanCenter.isEmpty(map) || BeanCenter.isEmpty(key)) {
            return null;
        }
        return cast(map.get(key), clazz);
    }

    /**
     * 
     * getClass:获取实例对应的class. <br/>
     * 获取实例对应的class.<br/>
     * 
     * @author haibing.shen
     * @param obj 源对象
     * @param <T> 实例类型
     * @return 实例
     * @since JDK 1.6
     */
    public static <T> Class<T> getClass(Object obj) {
        @SuppressWarnings("unchecked")
        Class<T> clazz= obj instanceof Class ? (Class<T>) obj : (Class<T>) obj.getClass();
        return clazz;
    }

    /**
     * 
     * getObject:获取对象. <br/>
     * 获取静态属性的空实例(不传实例).<br/>
     * 获取class对应的实例.<br/>
     * 
     * @author haibing.shen
     * @param src 源对象
     * @param <T> 实例类型
     * @return 实例
     * @since JDK 1.6
     */
    public static <T> Object getObject(Object src) {
        return src instanceof Class ? null : src;
    }

    /**
     * 
     * checkField:是否存在filed. <br/>
     * 是否存在filed.<br/>
     * 
     * @author haibing.shen
     * @param obj 源对象后class
     * @param fieldName 字段名
     * @param <T> 类型
     * @return 是否
     * @since JDK 1.6
     */
    public static <T> boolean checkField(Object obj, String fieldName) {
        try {
            Class<T> clazz= getClass(obj);
            Field field= clazz.getDeclaredField(fieldName);
            if (BeanCenter.isEmpty(field)) {
                return false;
            }
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 
     * getField:获取field. <br/>
     * 获取field.<br/>
     * 
     * @author haibing.shen
     * @param <T> 类型
     * @param obj 类型class或对象
     * @param fieldName 属性名
     * @return field
     * @since JDK 1.6
     */
    public static <T> Field getField(Object obj, String fieldName) {
        Field field= null;
        Class<T> clazz= getClass(obj);
        try {
            field= clazz.getDeclaredField(fieldName);
            if (BeanCenter.isEmpty(field)) {
                return null;
            }
            field.setAccessible(true);
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        return field;
    }

    /**
     * 
     * getFieldValue:获取field的value. <br/>
     * 获取静态类 field的value.<br/>
     * 获取实例对象field的value.<br/>
     * 
     * @author haibing.shen
     * @param obj 源对象
     * @param <T> 类型
     * @param fieldName 字段名
     * @return 字段值
     * @since JDK 1.6
     */
    public static <T> Object getFieldValue(Object obj, String fieldName) {
        Field field= getField(obj, fieldName);
        if (BeanCenter.isEmpty(field)) {
            return null;
        }
        Class<T> clazz= getClass(obj);
        Object obj1= getObject(obj);
        field.setAccessible(true);
        try {
            return field.get((Modifier.isStatic(field.getModifiers()) || BeanCenter.isEmpty(obj1)) ? clazz : obj1);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * setField:设置field. <br/>
     * 设置field.<br/>
     * 
     * @author haibing.shen
     * @param obj class或对象
     * @param fieldName field名称
     * @param <T> 类型
     * @param value 设置到field的值
     * @since JDK 1.6
     */
    public static <T> void setField(Object obj, String fieldName, Object value) {
        Field field= getField(obj, fieldName);
        if (BeanCenter.isEmpty(field)) {
            return;
        }
        Object obj1= getObject(obj);
        field.setAccessible(true);
        try {
            field.set(obj1, value);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * checkMethod:验证方法. <br/>
     * 验证方法.<br/>
     * 
     * @author haibing.shen
     * @param methods 已知的所有方法名列表
     * @param met 要验证的方法
     * @return 是否在给定的方法名列表中
     * @since JDK 1.6
     */
    public static boolean checkMethod(Method[] methods, String met) {
        if (BeanCenter.isNotEmpty(methods)) {
            for (Method method : methods) {
                if (met.equals(method.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * checkMethod:验证方法. <br/>
     * 验证方法.<br/>
     * 
     * @author haibing.shen
     * @param cls 源类class
     * @param met 方法名
     * @return 方法是否存在
     * @since JDK 1.6
     */
    public static boolean checkMethod(Class<?> cls, String met) {
        return BeanCenter.isNotEmpty(cls) ? checkMethod(cls.getDeclaredMethods(), met) : false;
    }

    /**
     * 
     * checkMethod:验证方法. <br/>
     * 验证方法.<br/>
     * 
     * @author haibing.shen
     * @param orig 源对象
     * @param met 方法名
     * @return 方法是是否存在
     * @since JDK 1.6
     */
    public static boolean checkMethod(Object orig, String met) {
        return BeanCenter.isNotEmpty(orig) ? checkMethod(orig.getClass(), met) : false;
    }

    /**
     * 
     * getMethod: 寻找方法. <br/>
     * 结合排列思想： 首次在取满所有参数前，用原参数试探 满了后， 每次修改 一一个参数（父类参数）就试探.<br/>
     * 
     * @author haibing.shen
     * @param cls 类的class
     * @param metName 方法名
     * @param destClsArgs 目标参数列表
     * @param destIdx 目标参数列表中索引
     * @param origClsArgs 源参数列表
     * @return 方法
     * @since JDK 1.6
     */
    public static Method getMethod(Class<?> cls, String metName, Class<?>[] destClsArgs, int destIdx,
            Class<?>... origClsArgs) {
        try {
            if (!BeanCenter.isNull(destClsArgs) && destIdx >= destClsArgs.length) {
                return getMethod(cls, metName, BeanCenter.isNotEmpty(destClsArgs) ? destClsArgs : null);
            }
            return getMethod(cls, metName, BeanCenter.isNotEmpty(origClsArgs) ? origClsArgs : null);// 在取满所有参数前，用原参数试探
        } catch (Exception ex) {
            Method dMethod= null;
            Class<?> oneArg= destIdx >= destClsArgs.length ? destClsArgs[destClsArgs.length - 1] : origClsArgs[destIdx];
            while (BeanCenter.isNotEmpty(oneArg.getSuperclass())) {
                destClsArgs[destIdx >= destClsArgs.length ? destClsArgs.length - 1
                        : destIdx]= destIdx >= destClsArgs.length ? oneArg.getSuperclass() : oneArg;
                boolean hasExist= true;
                for (int i= 0; i < origClsArgs.length; i++) {
                    if (!destClsArgs[i].equals(origClsArgs[i])) {
                        hasExist= false;
                        break;
                    }
                }
                if (hasExist) {// 已经试探过,取父亲参数
                    destClsArgs[destIdx]= oneArg.getSuperclass();
                    destIdx++;
                }
                oneArg= oneArg.getSuperclass();
                dMethod= getMethod(cls, metName, destClsArgs, destIdx++, origClsArgs);// return
                if (BeanCenter.isNotEmpty(dMethod)) {
                    break;
                }
            }
            return dMethod;
        }
    }

    /**
     * 
     * getMethod:获取方法. <br/>
     * 公有方法.<br/>
     * 私有方法.<br/>
     * 
     * @author haibing.shen
     * @param cls 类型
     * @param metName 方法名
     * @param argCls 参数
     * @return 返回方法
     * @throws SecurityException 安全异常
     * @throws NoSuchMethodException 没有这个方法的异常
     * @since JDK 1.6
     */
    public static Method getMethod(Class<?> cls, String metName, Class<?>[] argCls)
            throws NoSuchMethodException, SecurityException {
        argCls= BeanCenter.isNotEmpty(argCls) ? argCls : null;
        Method method= null;
        try {
            method= cls.getMethod(metName, argCls);
        } catch (Exception ex) {
            method= cls.getDeclaredMethod(metName, argCls);
        }

        return method;
    }

    /**
     * 
     * getConstructor: 寻找构造方法. <br/>
     * 结合排列思想： 首次在取满所有参数前，用原参数试探 满了后， 每次修改 一一个参数（父类参数）就试探.<br/>
     * 
     * @author haibing.shen
     * @param cls 类的class
     * @param destClsArgs 目标参数列表
     * @param destIdx 目标参数列表中索引
     * @param origClsArgs 源参数列表
     * @return 方法
     * @since JDK 1.6
     */
    public static Constructor<?> getConstructor(Class<?> cls, Class<?>[] destClsArgs, int destIdx,
            Class<?>... origClsArgs) {
        try {
            if (!BeanCenter.isNull(destClsArgs) && destIdx >= destClsArgs.length) {
                return getConstructor(cls, BeanCenter.isNotEmpty(destClsArgs) ? destClsArgs : null);
            }
            return getConstructor(cls, BeanCenter.isNotEmpty(origClsArgs) ? origClsArgs : null);// 在取满所有参数前，用原参数试探
        } catch (Exception ex) {
            Constructor<?> destConstructor= null;
            Class<?> oneArg= destIdx >= destClsArgs.length ? destClsArgs[destClsArgs.length - 1] : origClsArgs[destIdx];
            while (BeanCenter.isNotEmpty(oneArg.getSuperclass())) {
                destClsArgs[destIdx >= destClsArgs.length ? destClsArgs.length - 1
                        : destIdx]= destIdx >= destClsArgs.length ? oneArg.getSuperclass() : oneArg;
                boolean hasExist= true;
                for (int i= 0; i < origClsArgs.length; i++) {
                    if (!destClsArgs[i].equals(origClsArgs[i])) {
                        hasExist= false;
                        break;
                    }
                }
                if (hasExist) {// 已经试探过,取父亲参数
                    destClsArgs[destIdx]= oneArg.getSuperclass();
                    destIdx++;
                }
                oneArg= oneArg.getSuperclass();
                destConstructor= getConstructor(cls, destClsArgs, destIdx++, origClsArgs);// return
                if (BeanCenter.isNotEmpty(destConstructor)) {
                    break;
                }
            }
            return destConstructor;
        }
    }

    /**
     * 
     * getConstructor:获取构造方法. <br/>
     * 公有方法.<br/>
     * 私有方法.<br/>
     * 
     * @author haibing.shen
     * @param cls 类型
     * @param args 参数
     * @return 返回方法
     * @throws SecurityException 安全异常
     * @throws NoSuchMethodException 没有这个方法的异常
     * @since JDK 1.6
     */
    public static Constructor<?> getConstructor(Class<?> cls, Class<?>[] args)
            throws NoSuchMethodException, SecurityException {
        args= BeanCenter.isNotEmpty(args) ? args : null;
        Constructor<?> constructor= null;
        try {
            constructor= BeanCenter.isNotEmpty(args) ? cls.getConstructor(args) : cls.getConstructor();
        } catch (Exception ex) {
            constructor= BeanCenter.isNotEmpty(args) ? cls.getDeclaredConstructor(args) : cls.getDeclaredConstructor();
        }

        return constructor;
    }

    /**
     * 
     * invoke:执行方法. <br/>
     * 执行方法,实例方法传实例.<br/>
     * 执行方法,静态方法传null.<br/>
     * 
     * @author haibing.shen
     * @param obj 源对象
     * @param metName 方法名
     * @param args 参数列表
     * @return 返回值
     * @since JDK 1.6
     */
    public static Object invoke(Object obj, String metName, Object... args) { // args.getClass().getClasses() []
                                                                              // args.getClass().getName().equals("[Ljava.lang.Integer;")
        try {
            Class<?> cls= getClass(obj);// obj instanceof Class ? (Class<?>) obj : obj.getClass();
            Method[] methods= cls.getMethods();// cls.getDeclaredMethods(); //不单是自己类定义的，还包括父亲类定义的

            if (!checkMethod(methods, metName) && !checkMethod(cls.getDeclaredMethods(), metName)) {// 验证public/private方法
                return null;
            }
            // 参数类型由是否传入参数而决定
            Method method= getMethod(cls, metName, new Class<?>[args.length], 0, getClazzs(args));
            // Method method = cls.getMethod(metName, BaseUtils.isNotEmpty(args) ? args[0].getClass() : null);
            method.setAccessible(true);// 方法可访问
            Object obj1= getObject(obj);
            Object object= method.invoke(obj1, args); // new Object[]{} 静态方法传null

            return object;
        } catch (Exception ex) {// throws NoSuchMethodException, SecurityException, IllegalAccessException,
                                // IllegalArgumentException, InvocationTargetException
            // log.error(ExceptionUtils.getFullStackTrace(ex));
        }
        return null;
    }

    /**
     * 
     * getClazzs:参数的class. <br/>
     * 参数的class.<br/>
     * 
     * @author haibing.shen
     * @param args 参数值列表
     * @return 参数类型class列表
     * @since JDK 1.6
     */
    public static Class<?>[] getClazzs(Object... args) {
        Class<?>[] clazzs= new Class<?>[args.length];
        for (int i= 0; i < args.length; i++) {
            clazzs[i]= args[i].getClass();
        }
        return clazzs;
    }

    /**
     * 
     * invoke:反射性执行方法. <br/>
     * 反射性执行方法.<br/>
     * 
     * @author haibing.shen
     * @param obj bean对象
     * @param metName 方法名
     * @param <T> 返回类型
     * @param metRetClazz 返回类型class
     * @param args 实参数列表
     * @return 返回值
     * @since JDK 1.6
     */
    public static <T> T invoke(Object obj, String metName, Class<T> metRetClazz, Object... args) {
        return cast(invoke(obj, metName, args), metRetClazz);
    }

    /**
     * 代理实例.
     * 
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
