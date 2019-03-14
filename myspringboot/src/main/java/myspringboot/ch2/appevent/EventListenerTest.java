package myspringboot.ch2.appevent;

import myspringboot.ch1.AnotatitionConfigTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class EventListenerTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventListenerTest.class);
		EventPublisher bean = ctx.getBean(EventPublisher.class);
		bean.monitorPublish("Hello,this is My event!");
		
		ctx.publishEvent(new MyEvent("", "直接使用初始化容器调用！"));
		ctx.close();
	}
}
