package myspringboot.ch3.combination;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //组合注解 将Configuration和ComponentScan组合在一起
@ComponentScan
public @interface ConfigurationScan {

	String[] value() default {};//覆盖value参数
	
}
