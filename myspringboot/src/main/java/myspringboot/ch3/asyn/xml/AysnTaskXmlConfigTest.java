package myspringboot.ch3.asyn.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AysnTaskXmlConfigTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("classpath:/asyn.xml");
		AsynTaskXmlService service = contxt.getBean(AsynTaskXmlService.class);
		for(int i=0;i<10;i++){
			service.asynTaskWithXmlConfig(i);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contxt.close();
	}

}
