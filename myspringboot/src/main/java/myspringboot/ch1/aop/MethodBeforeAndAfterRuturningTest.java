package myspringboot.ch1.aop;

import junit.framework.TestCase;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages={"myspringboot.ch1.aop"})
public class MethodBeforeAndAfterRuturningTest extends TestCase{

	//编程式增强
	public void testClient1(){
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
		
		proxyFactory.addAdvice(new GreetingAroundAdvice());
		
		Greeting greeting = (Greeting) proxyFactory.getProxy();
		greeting.sayHello("Jackson");
	}
	
	//声明式增强 基于XML
	public void testClient2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/aop.xml");
		Greeting greeting = (Greeting) context.getBean("greetingProxy");
		greeting.sayHello("Jackson");
	}
	
	//声明式增加 基于Annotation
	public void testClient3(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MethodBeforeAndAfterRuturningTest.class);
		Greeting greeting = (Greeting)  context.getBean("greetingProxy");
		greeting.sayHello("Jackson");
		context.close();
	}
	
	@Bean
	public ProxyFactoryBean greetingProxy(){
		ProxyFactoryBean bean = new ProxyFactoryBean();
		bean.setTargetName("greeting");
		bean.setInterceptorNames("greetingBeforeAndAfterAdvice","greetingAroundAdvice");
		return bean;
	}
	
	public void testClient4(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/aop.xml");
		GreetingImpl greeting = (GreetingImpl) context.getBean("greetingIntroductionProxy");
		greeting.sayHello("Jackson");
		
		Love love = (Love)greeting;
		love.display("Sura");
	}
}
