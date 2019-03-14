package myspringboot.ch2;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@ComponentScan(basePackages={"myspringboot.ch2"})
@Configuration
@PropertySource(value={"classpath:jdbc.properties"})
public class ELTest extends TestCase {
	
	//导入配置文件值 使用 $
	@Value("${jdbcUrl}")
	private String jdbcUrl;
	
	@Value("小学生")//普通字符串
	private String grade;
	
	@Value("#{singletonService.another}")//使用其他类的值
	private String another;
	
	@Value("#{systemProperties['os.name']}")//使用系统的变量
	private String osName;
	
	@Value("http://www.baidu.com")
	private Resource baiduUrl;
	
	@Value("#{T (java.lang.Math).random()*100}")
	private Double randomDouble;
	
	@Autowired
	private Environment environment;
	
	@Bean //这里强调一下 要使配置文件的内容生效，必须配置此Bean 而且必须是static
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public void testEL() throws IOException{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ELTest.class);
		ELTest test = ctx.getBean(ELTest.class);
		
		System.out.println("JDBC URL = "+test.jdbcUrl);
		System.out.println("Grade = "+test.grade);
		System.out.println("another = "+test.another);
		System.out.println("osName = "+test.osName);
		System.out.println("randomDouble=" +test.randomDouble);
		System.out.println("Baidu="+IOUtils.toString(test.baiduUrl.getInputStream()));
		System.out.println("从environment中读取数据："+test.environment.getProperty("driverClass"));
		ctx.close();
	}
}
