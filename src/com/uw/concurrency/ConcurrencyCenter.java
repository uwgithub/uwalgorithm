/**  
 * Project Name:uwalgorithm  
 * File Name:ConcurrencyCenter.java  
 * Package Name:com.uw.concurrency  
 * Date:2019年4月9日下午9:52:17  
 * Copyright (c) 2019, haifei201510@uw.com All Rights Reserved.  
 *  
*/

package com.uw.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.uw.designpatterns.SinglePattern;
import com.uw.reflect.ReflectCenter;

/**
 * ClassName:ConcurrencyCenter <br/>
 * Function: 并发处理. <br/>
 * Reason: 并发处理. <br/>
 * Date: 2019年4月9日 下午9:52:17 <br/>
 * 
 * @author haibing.shen
 * @version
 * @since JDK 1.6
 * @see
 */
public class ConcurrencyCenter{
    /**
     * 最大可处理任务上限值
     */
    public final static int MAXTASKSIZE= 10;

    /**
     * 任务数
     */
    // public static int sysnchronizedQueueNo= 0;

    /**
     * 并发处理的任务量
     */
    private static int CONCURRENTCYSIZE= 0;

    /**
     * 单例线程池引用
     */
    private static ExecutorService newCachedThreadPool;

    /**
     * 
     * concurrencyUpdate:更新并发任务量. <br/>
     * 更新并发任务量.<br/>
     * 
     * @author haibing.shen
     * @param inc 更新量
     * @since JDK 1.6
     */
    private static synchronized void concurrencyUpdate(int inc) {
        CONCURRENTCYSIZE+= inc;
    }

    /**
     * 
     * concurrencyHandler:并发处理. <br/>
     * 并发处理.<br/>
     * 
     * @author haibing.shen
     * @param obj 源对象
     * @param metName 源方法
     * @param <T> 源方法返回类型
     * @param metRetClazz 源方法返回class
     * @param args 源方法列表
     * @since JDK 1.6
     */
    public static <T> void concurrencyHandler(Object obj, String metName, Class<T> metRetClazz, Object... args) {
        // ExecutorService cachedThreadPool= SinglePattern.singleInstance(
        // ReflectCenter.newIFInstance(new Class<?>[] { Executors.class}), "newCachedThreadPool",
        // ExecutorService.class); newCachedThreadPool
        newCachedThreadPool= SinglePattern.singleInstance(newCachedThreadPool, Executors.class, "newCachedThreadPool",
                ExecutorService.class);// 创建一个单例线程池，以处理并发任务

        // ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
        if (CONCURRENTCYSIZE > MAXTASKSIZE) {
            return;// 不处理超过上限的并发
        }
        concurrencyUpdate(1);// 标识增加一个任务
        /*
         * for (int i= 0; i < MAXTASKSIZE; i++) { final int index= CONCURRENTCYSIZE; }
         */
        try {
            Thread.sleep(CONCURRENTCYSIZE * 10);// 所有处理过的任务累加
        } catch (Exception e) {
            e.printStackTrace();
        }

        newCachedThreadPool.execute(new Runnable(){
            @Override
            public void run() { // System. out . print l n(index + "当前线程" + Thread.currentThread().getName());
                ReflectCenter.invoke(obj, metName, metRetClazz, args);
                concurrencyUpdate(-1);// 处理完，就标识并发量减1
            }
        });

        /*
         * Future<Object> future= newCachedThreadPool.submit( new Callable<Object>(){ // 接收一个Callable实例 public Object
         * call() { ReflectCenter.invoke(obj, metName, metRetClazz, args); return ""; } });
         */

        // concurrencyUpdate(-1);// 处理完，就标识并发量减1
        // }
        // 执行当前任务就关闭线程池,不使得已经完成的任务重复执行

    }
}
