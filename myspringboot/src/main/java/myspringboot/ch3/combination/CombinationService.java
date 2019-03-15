package myspringboot.ch3.combination;

import org.springframework.stereotype.Service;

@Service
public class CombinationService {

	public void outputResult(){
		System.out.println("从组合注解的配置中获得Bean...");
	}
	
}
