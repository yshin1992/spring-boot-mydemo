package myspringboot.ch1.aop.javaconfig;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect//定义这是一个切面
@Component
public class LogAspect {

	@Pointcut("@annotation(myspringboot.ch1.aop.javaconfig.Action)")//定义PointCut
	public void annotationPointCut(){}
	
	@After("annotationPointCut()") //使用PointCut定义的切点
	public void after(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截:"+action.name());
	}
	
	@Before("execution(* myspringboot.ch1.aop.javaconfig.DemoMethodService.*(..))")//使用拦截式规则作为参数
	public void before(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截:"+method.getName());
	}
}
