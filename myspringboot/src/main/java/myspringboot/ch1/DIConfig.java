package myspringboot.ch1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//声明这是一个配置文件
@ComponentScan(basePackages={"myspringboot.ch1"})//声明扫描myspringboot.ch1的所有类，并注册为Bean
public class DIConfig {

	
	
}
