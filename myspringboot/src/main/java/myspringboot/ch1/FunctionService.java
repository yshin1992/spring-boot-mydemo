package myspringboot.ch1;

import org.springframework.stereotype.Service;

@Service//声明这是Spring管理的Bean
public class FunctionService {

	public String sayHello(String words){
		return "Hello " + words +"!";
	}
}
