package myspringboot.ch2.appevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

	public void onApplicationEvent(MyEvent event) {
		String message = event.getMessage();
		System.out.println(message);
	}

}
