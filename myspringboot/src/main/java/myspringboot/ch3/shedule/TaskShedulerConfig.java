package myspringboot.ch3.shedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling //开启对计划任务的支持
public class TaskShedulerConfig {

}
