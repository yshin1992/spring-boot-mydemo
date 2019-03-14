package myspringboot.ch1.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("Return value="+returnValue);
		System.out.println("Method ="+method.getName());
		System.out.println("Args ="+Arrays.toString(args));
		System.out.println(target==null?"null":target.getClass().getName());
		System.out.println("After Returning.....");
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Method ="+method.getName());
		System.out.println("Args ="+Arrays.toString(args));
		System.out.println(target==null?"null":target.getClass().getName());
		System.out.println("Method before....");
	}

}
