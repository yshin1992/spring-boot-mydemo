package myspringboot.ch3.asyn;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class LogAsynExecutor implements AsyncConfigurer {

	@Bean(name="logExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.initialize();
		return taskExecutor;
	}
	
	
	@Bean(name="daoExecutor")
	public Executor getDaoExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.initialize();
		return taskExecutor;
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}


}
