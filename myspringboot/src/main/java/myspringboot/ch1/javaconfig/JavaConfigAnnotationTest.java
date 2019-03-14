package myspringboot.ch1.javaconfig;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigAnnotationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		
		System.out.println(useFunctionService.sayHello("Link"));
		
		context.close();
	}

}
