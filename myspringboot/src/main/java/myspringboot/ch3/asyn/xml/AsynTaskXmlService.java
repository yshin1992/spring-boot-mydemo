package myspringboot.ch3.asyn.xml;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynTaskXmlService {

	@Async(value="defaultTaskExecutor")
	public void asynTaskWithXmlConfig(Integer index){
		System.out.println("Index..."+index);
	}
}
