package myspringboot.ch3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AwareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AwareTest.class);
		
		AwareService bean = ctx.getBean(AwareService.class);
		
		bean.output();
		
		ctx.close();
		
		
	}

}
