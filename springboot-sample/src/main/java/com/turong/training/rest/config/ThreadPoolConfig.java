package com.turong.training.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

    @Value("${pool.corePoolSize:50}")
    private int corePoolSize;

    @Value("${pool.maxPoolSize:50}")
    private int maxPoolSize;

    @Bean(name = "poolExecutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor poolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setThreadNamePrefix("workflowEventExecutor-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

}
