package myspringboot.ch2.appevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service//模拟发布事件的类
public class EventPublisher {

	@Autowired
	ApplicationContext applicationContext;
	
	public void monitorPublish(String message){
		applicationContext.publishEvent(new MyEvent("", message));
	}
}
