package com.threadpool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 手动定义线程池参数，避免出现OOM
 * 采用的是无界队列（当任务数大于核心线程数，多余的任务在队列排队
 * 到有空闲的线程才去处理）
 * @Author: PengMvc
 * @Date: 2022/05/26/20:37
 */
public class CommonThreadPool {

    // 核心线程池
    private static final int CORE_POOL_SIZE = 10;
    // 线程活跃时间
    private static final int KEEP_ALIVE_TIME = 60;

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            Integer.MAX_VALUE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(),
            new DefaultThreadFactory("CommonThreadPool",false),
            new ThreadPoolExecutor.AbortPolicy());

    public static ThreadPoolExecutor getExecutor() {
        return EXECUTOR;
    }
}
