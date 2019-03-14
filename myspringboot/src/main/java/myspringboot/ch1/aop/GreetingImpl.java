package myspringboot.ch1.aop;

import org.springframework.stereotype.Service;

@Service(value="greeting")
public class GreetingImpl implements Greeting {

	public void sayHello(String word) {
		System.out.println("Say : "+word);
	}

}
