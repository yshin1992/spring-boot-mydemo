package myspringboot.ch1.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class DaoAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		Object[] params = invocation.getArguments();
		System.out.println("执行方法["+method.getName()+"("+Arrays.toString(params) +")");
		Object result = invocation.proceed();
		System.out.println("执行结果:"+result);
		return result;
	}

}
