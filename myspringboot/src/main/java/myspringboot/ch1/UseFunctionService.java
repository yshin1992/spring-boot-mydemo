package myspringboot.ch1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//声明这是Spring管理的Bean
public class UseFunctionService {
	
	@Autowired//将FunctionService的实体Bean注入进来(与Resource和Inject注解同效)
	FunctionService functionService;
	
	public String sayHello(String word){
		return functionService.sayHello(word);
	}
}
