package myspringboot.ch4;

import java.util.List;

import myspringboot.ch4.interceptor.DemoInterceptor;
import myspringboot.ch4.messageConvertor.MyMessageConvertor;
import myspringboot.ch4.model.DemoObj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableScheduling//开启计划任务的支持
@ComponentScan("myspringboot.ch4")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/classes/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	//处理静态资源
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	//添加拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	
	//添加快捷的view访问
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		
		registry.addViewController("/convertor").setViewName("convertor");
		registry.addViewController("/sse").setViewName("sse");
		registry.addViewController("/asyn").setViewName("asyn");
	}

	//路径匹配参数,通过重写这个方法设置不可忽略访问路径上‘.’后面的参数
	public void configurePathMatch(PathMatchConfigurer configurer){
		configurer.setUseSuffixPatternMatch(false);
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(8*1024*1024*3);//定义最大上传大小为3M
		return resolver;
	}
	
	@Bean
	public HttpMessageConverter<DemoObj> myHttpMessageConverter(){
		return new MyMessageConvertor();
	}
	
	//添加我们自定义的Message Convertor
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(myHttpMessageConverter());
	}
	
}
