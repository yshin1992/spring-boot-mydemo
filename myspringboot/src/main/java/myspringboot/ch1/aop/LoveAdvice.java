package myspringboot.ch1.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class LoveAdvice extends DelegatingIntroductionInterceptor implements Love{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3973483578546684219L;
	
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		return super.invoke(mi);
	}



	public void display(String name) {
		System.out.println("My Love : "+name);
	}

}
