package myspringboot.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListService listService = ctx.getBean(ListService.class);
		System.out.println(ctx.getEnvironment().getProperty("os.name")+"系统下的列表命令为:"+listService.showListCmd());
		ctx.close();
	}

}
