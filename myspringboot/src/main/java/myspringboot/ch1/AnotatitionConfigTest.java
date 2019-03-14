package myspringboot.ch1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnotatitionConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DIConfig.class);
		UseFunctionService useFunctionService = ctx.getBean(UseFunctionService.class);
		
		System.out.println(useFunctionService.sayHello("Link"));
		
		ctx.close();
	}
}
