package myspringboot.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.TestCase;

public class ProfileTest extends TestCase {

	public void testWithJavaConfig(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("prod");
		ctx.register(ProfileConfig.class);//注意这里需要后置注册Bean配置类，不然会报Bean未定义的错误
		ctx.refresh();//刷新容器
		DemoBean bean = ctx.getBean(DemoBean.class);
		System.out.println(bean.getContent());
		ctx.close();
		
	}
	
}
