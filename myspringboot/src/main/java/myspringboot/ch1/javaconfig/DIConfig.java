package myspringboot.ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//声明这是一个配置文件
@ComponentScan(basePackages={"myspringboot.ch1.javaconfig"})//声明扫描myspringboot.ch1的所有类，并注册为Bean
public class DIConfig {

	@Bean
	public FunctionService functionService(){
		return new FunctionService();
	}
	
	@Bean
	public UseFunctionService useFunctionService(){
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService());
		return useFunctionService;
	}
	
	
}
