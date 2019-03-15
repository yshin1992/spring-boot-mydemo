package myspringboot.ch3.shedule;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScheduleTaskTest {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext contxt = new AnnotationConfigApplicationContext(TaskShedulerConfig.class);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/scheduler.xml");
		
	}
}
