package myspringboot.ch1.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class GreetingAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("Before");
		Object result = arg0.proceed();
		System.out.println("After");
		return result;
	}
}
