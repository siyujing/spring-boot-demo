package com.testingedu.utilsdemo.App.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 创建线程池
 * */
@EnableAsync
@Configuration
public class BeAsyncException {
    @Bean(name = "BeAsyncExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(50);
        taskExecutor.setQueueCapacity(5000);
        taskExecutor.afterPropertiesSet();
        taskExecutor.setThreadNamePrefix("BeAsyncExecutor");
        return taskExecutor;
    }
}
