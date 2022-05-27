package com.threadpool;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.ThreadPoolExecutor;

/**
 *  继承父线程http请求上下文
 * @Author: PengMvc
 * @Date: 2022/05/26/20:42
 */
public class SpringContextPool {

    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 20;
    private static final int QUEUE_CAPACITY = 1024;
    private static final int KEEP_ALIVE_TIME = 60;

    private static final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    static {
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadFactory(new DefaultThreadFactory("context-pool", false));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.setTaskDecorator(runnable -> {
            try {
                RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
                return () -> {
                    try {
                        RequestContextHolder.setRequestAttributes(attributes);
                        runnable.run();
                    } finally {
                        RequestContextHolder.resetRequestAttributes();
                    }
                };
            } catch (IllegalStateException e) {
                return runnable;
            }
        });
        executor.initialize();
    }

    public static ThreadPoolTaskExecutor getExecutor() {
        return executor;
    }
}
