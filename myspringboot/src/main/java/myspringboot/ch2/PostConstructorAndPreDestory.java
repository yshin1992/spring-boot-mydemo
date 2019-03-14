package myspringboot.ch2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import junit.framework.TestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class PostConstructorAndPreDestory extends TestCase {

	public void testWithXml(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/beans.xml");
		Object bean = context.getBean("singletonService");
		context.getBean("singletonService");
	}
	
	public void testWithAnnotation(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELTest.class);
		context.getBean("singletonService");
		context.close();
	}
	
	public void testWithJavaConfig(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELTest.class);
		Object bean=context.getBean("beanUsedByPostPreService");
		context.close();
	}
	
	@Bean(initMethod="init",destroyMethod="destroy")
	public BeanUsedByPostPreService beanUsedByPostPreService(){
		return new BeanUsedByPostPreService();
	}
	
}
