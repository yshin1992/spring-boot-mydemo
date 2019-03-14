package myspringboot.ch2;

import junit.framework.TestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"myspringboot.ch2"})
public class BeanScopeTest extends TestCase {
	
	public void testScopeSingleton(){
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(BeanScopeTest.class);
		SingletonService bean1 = ctx.getBean(SingletonService.class);
		SingletonService bean2 = ctx.getBean(SingletonService.class);
		System.out.println(bean1 == bean2);//结果为true
		ctx.close();
	}
	
	public void testScopeProperty(){
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(BeanScopeTest.class);
		PrototypeService bean1 = ctx.getBean(PrototypeService.class);
		PrototypeService bean2 = ctx.getBean(PrototypeService.class);
		System.out.println(bean1 == bean2);//结果为false
		ctx.close();
	}
	
}
