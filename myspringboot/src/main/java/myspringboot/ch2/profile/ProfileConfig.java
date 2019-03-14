package myspringboot.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration//声明这是一个配置累
public class ProfileConfig {

	@Bean
	@Profile(value="dev")
	public DemoBean devDemoBean(){
		return new DemoBean("From development");
	}
	
	@Bean
	@Profile(value="prod")
	public DemoBean prdDemoBean(){
		return new DemoBean("From Production");
	}
}
