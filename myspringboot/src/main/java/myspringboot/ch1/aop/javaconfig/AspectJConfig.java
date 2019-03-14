package myspringboot.ch1.aop.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("myspringboot.ch1.aop.javaconfig")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectJConfig {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(AspectJConfig.class);
		DemoMethodService demoMethodService = ctx.getBean(DemoMethodService.class);
		demoMethodService.add();
		
		ctx.close();
	}
	
}
