package myspringboot.ch3.asyn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsynTest {
	
	public void testAsynTask(){
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		//注意只能存在一个 类实现 AsyncConfigurer
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AsynConfig.class);
		AsynTaskService asynTaskService = ctx.getBean(AsynTaskService.class);
		for(int i=0;i<10;i++){
			asynTaskService.executeAsynTask(i);
			asynTaskService.executeAsynTaskPlus(i);
		}
		Thread.sleep(2000);
		ctx.close();
	}
}
