package myspringboot.ch3.asyn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync//开启异步事务
@Configuration
@ComponentScan
public class AsynConfig{

	
}
