package myspringboot.ch4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 关于为何定义这个就能启动起Web项目，可参考下列博客
 * https://blog.csdn.net/zq17865815296/article/details/79464403
 * https://www.cnblogs.com/huzi007/p/6679215.html
 * @author yshin1992
 *
 */
public class WebInitializer 
 implements WebApplicationInitializer 

{
	
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyMvcConfig.class);
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		servlet.setAsyncSupported(true);//开启异步方法支持
	}

}
